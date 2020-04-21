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

package com.example.jhordan.euro_cleanarchitecture.data.repository.datasource;

import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.example.jhordan.euro_cleanarchitecture.data.local.LocalTeamApi;
import com.example.jhordan.euro_cleanarchitecture.data.local.LocalTeamApiToTeamEntityMapper;
import io.reactivex.Observable;
import java.util.List;

public class TeamsLocalDataSource {

    private final LocalTeamApi localTeamApi;
    private final LocalTeamApiToTeamEntityMapper localTeamApiToTeamEntityMapper;

    public TeamsLocalDataSource(LocalTeamApi localTeamApi, LocalTeamApiToTeamEntityMapper localTeamApiToTeamEntityMapper) {
        this.localTeamApi = localTeamApi;
        this.localTeamApiToTeamEntityMapper = localTeamApiToTeamEntityMapper;
    }

    public Observable<List<TeamEntity>> teamEntityList() {
        return Observable.create(emitter -> {
            List<TeamEntity> teamEntityList = getAll();
            if (teamEntityList != null) {
                emitter.onNext(teamEntityList);
                emitter.onComplete();
            } else {
                emitter.onError(
                        new Throwable("Error getting team data list from the local json (euro_data.json)"));
            }
        });
    }

    public Observable<TeamEntity> teamEntity(String flag) {
        return Observable.create(emitter -> {
            TeamEntity teamEntity = getByFlag(flag);
            if (teamEntity != null) {
                emitter.onNext(teamEntity);
                emitter.onComplete();
            } else {
                emitter.onError(
                        new Throwable("Error getting team data by flag from the local json (euro_data.json)"));
            }
        });
    }

    private List<TeamEntity> getAll() {
        return localTeamApiToTeamEntityMapper.transformTeamEntityCollection(localTeamApi.readEuroDataJson());
    }

    private TeamEntity getByFlag(String flag) {
        TeamEntity result = null;
        for (TeamEntity entity : getAll()) {
            if (entity.getTeamFlag().equals(flag)) {
                result = entity;
                break;
            }
        }
        return result;
    }
}
