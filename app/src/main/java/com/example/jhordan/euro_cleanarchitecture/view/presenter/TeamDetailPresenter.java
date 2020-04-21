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
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetTeamUseCase;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;
import com.example.jhordan.euro_cleanarchitecture.view.model.mapper.TeamToTeamUiMapper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class TeamDetailPresenter extends Presenter<TeamDetailPresenter.View> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final GetTeamUseCase getTeamUseCase;
    private final TeamToTeamUiMapper teamToTeamUiMapper;
    private String teamFlag;

    @Inject
    public TeamDetailPresenter(@NonNull GetTeamUseCase getTeamUseCase,
                               @NonNull TeamToTeamUiMapper teamToTeamUiMapper) {
        this.getTeamUseCase = getTeamUseCase;
        this.teamToTeamUiMapper = teamToTeamUiMapper;
    }

    public void setTeamFlag(String teamFlag) {
        this.teamFlag = teamFlag;
    }

    @Override
    public void initialize() {
        super.initialize();
        Disposable disposable = getTeamUseCase.getTeam(teamFlag)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(teamToTeamUiMapper::map)
                .subscribe(teamUi -> getView().showTeam(teamUi), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void destroy() {
        compositeDisposable.dispose();
        setView(null);
    }

    public interface View extends Presenter.View {
        void showTeam(TeamUi teamUi);
    }
}
