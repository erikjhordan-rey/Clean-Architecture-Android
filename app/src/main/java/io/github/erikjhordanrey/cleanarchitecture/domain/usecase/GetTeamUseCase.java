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

package io.github.erikjhordanrey.cleanarchitecture.domain.usecase;

import io.github.erikjhordanrey.cleanarchitecture.data.repository.TeamsRepository;
import io.github.erikjhordanrey.cleanarchitecture.domain.model.Team;

import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;

public class GetTeamUseCase {

    private final TeamsRepository teamsRepository;

    @Inject
    public GetTeamUseCase(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    public Observable<Team> getTeam(String flag) {
        return teamsRepository.getTeam(flag);
    }
}
