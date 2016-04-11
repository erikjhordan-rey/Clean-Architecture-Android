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

import android.support.annotation.NonNull;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.DefaultSubscriber;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetEuroTeams;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.mapper.TeamViewModelToTeamMapper;
import java.util.List;
import javax.inject.Inject;

public class TeamsPresenter extends Presenter<TeamsPresenter.View> {

  private GetEuroTeams getEuroTeams;
  private TeamViewModelToTeamMapper mapper;

  @Inject public TeamsPresenter(@NonNull GetEuroTeams getEuroTeams,
      @NonNull TeamViewModelToTeamMapper mapper) {
    this.getEuroTeams = getEuroTeams;
    this.mapper = mapper;
  }

  @Override public void initialize() {
    super.initialize();
    getView().showLoading();
    getEuroTeams.execute(new TeamLisSubscriber());
  }

  public void onTeamClicked(TeamViewModel team) {
    getView().openTeamScreen(team);
  }

  private final class TeamLisSubscriber extends DefaultSubscriber<List<Team>> {
    @Override public void onCompleted() {
      getView().hideLoading();
    }

    @Override public void onError(Throwable e) {
      getView().hideLoading();
      e.printStackTrace();
    }

    @Override public void onNext(List<Team> teamList) {
      getView().hideLoading();
      List<TeamViewModel> teamViewModels = mapper.reverseMap(teamList);
      getView().showEuroTeams(teamViewModels);
    }
  }

  public interface View extends Presenter.View {

    void hideEmptyCase();

    void showEuroTeams(List<TeamViewModel> teamList);

    void openTeamScreen(TeamViewModel team);
  }
}
