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
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetTeamsUseCase;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;
import com.example.jhordan.euro_cleanarchitecture.view.model.mapper.TeamToTeamUiMapper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class TeamsPresenter extends Presenter<TeamsPresenter.View> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
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
        Disposable disposable = getTeamsUseCase.getTeamList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(teamToTeamUiMapper::map)
                .doOnTerminate(() -> getView().hideLoading())
                .subscribe(teamUiList -> getView().showEuroTeams(teamUiList), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void onTeamClicked(TeamUi team) {
        getView().openTeamScreen(team);
    }

    public void destroy() {
        compositeDisposable.dispose();
        setView(null);
    }

    public interface View extends Presenter.View {

        void showEuroTeams(List<TeamUi> teamList);

        void openTeamScreen(TeamUi team);

        void showLoading();

        void hideLoading();
    }
}
