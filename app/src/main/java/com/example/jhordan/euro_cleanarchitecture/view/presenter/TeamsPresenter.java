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

import com.example.jhordan.euro_cleanarchitecture.core.presenter.Presenter;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetTeamsUseCase;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;
import com.example.jhordan.euro_cleanarchitecture.view.model.mapper.TeamToTeamUiMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class TeamsPresenter extends Presenter<TeamsPresenter.View> {

    private final GetTeamsUseCase getTeamsUseCase;
    private final TeamToTeamUiMapper teamToTeamUiMapper;

    @Inject
    public TeamsPresenter(@NonNull GetTeamsUseCase getTeamsUseCase, @NonNull TeamToTeamUiMapper teamToTeamUiMapper) {
        this.getTeamsUseCase = getTeamsUseCase;
        this.teamToTeamUiMapper = teamToTeamUiMapper;
    }

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        getTeamsUseCase.execute(new DisposableObserver<List<Team>>() {

            @Override
            public void onNext(List<Team> teams) {
                final List<TeamUi> teamUis = teamToTeamUiMapper.map(teams);
                getView().showEuroTeams(teamUis);
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }

    public void onTeamClicked(TeamUi team) {
        getView().openTeamScreen(team);
    }

    public void destroy() {
        getTeamsUseCase.dispose();
        setView(null);
    }

    public interface View extends Presenter.View {

        void showEuroTeams(List<TeamUi> teamList);

        void openTeamScreen(TeamUi team);

        void showLoading();

        void hideLoading();
    }
}
