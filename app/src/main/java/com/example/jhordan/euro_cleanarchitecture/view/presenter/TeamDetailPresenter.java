/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.jhordan.euro_cleanarchitecture.view.presenter;

import androidx.annotation.NonNull;

import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetTeamUseCase;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.mapper.TeamViewModelToTeamMapper;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class TeamDetailPresenter extends Presenter<TeamDetailPresenter.View> {

  private final GetTeamUseCase getTeamUseCase;
  private final TeamViewModelToTeamMapper mapper;
  private String teamFlag;

  @Inject public TeamDetailPresenter(@NonNull GetTeamUseCase getTeamUseCase,
      @NonNull TeamViewModelToTeamMapper mapper) {
    this.getTeamUseCase = getTeamUseCase;
    this.mapper = mapper;
  }

  @SuppressWarnings("unchecked") @Override public void initialize() {
    super.initialize();
    getView().showLoading();
    getTeamUseCase.searchTeamByFlag(teamFlag);
    getTeamUseCase.execute(new DisposableObserver<Team>() {
      @Override public void onComplete() {
        getView().hideLoading();
      }

      @Override public void onError(Throwable e) {
        getView().hideLoading();
      }

      @Override public void onNext(Team team) {
        TeamViewModel teamViewModel = mapper.reverseMap(team);
        getView().showTeam(teamViewModel);
      }
    });
  }

  public void setTeamFlag(String teamFlag) {
    this.teamFlag = teamFlag;
  }

  public void destroy() {
    this.getTeamUseCase.dispose();
    setView(null);
  }

  public interface View extends Presenter.View {
    void showTeam(TeamViewModel teamViewModel);
  }
}
