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

package com.example.jhordan.euro_cleanarchitecture.data.repository;

import androidx.annotation.NonNull;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamsLocalDataSource;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamEntityToTeamMapper;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

public class TeamsRepository {

    private final TeamsLocalDataSource teamsLocalDataSource;
    private final TeamEntityToTeamMapper teamEntityToTeamMapper;

    public TeamsRepository(@NonNull TeamsLocalDataSource teamsLocalDataSource, @NonNull TeamEntityToTeamMapper teamEntityToTeamMapper) {
        this.teamsLocalDataSource = teamsLocalDataSource;
        this.teamEntityToTeamMapper = teamEntityToTeamMapper;
    }

    public Observable<List<Team>> getTeamList() {
        return teamsLocalDataSource.teamEntityList().map(teamEntityToTeamMapper::map);
    }

    public Observable<Team> getTeam(String flag) {
        return teamsLocalDataSource.teamEntity(flag).map(teamEntityToTeamMapper::map);
    }
}
