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

package io.github.erikjhordanrey.cleanarchitecture.data.repository;

import io.github.erikjhordanrey.cleanarchitecture.fake.FakeTeamLocalAPI;
import io.github.erikjhordanrey.cleanarchitecture.data.repository.datasource.TeamEntityToTeamMapper;
import io.github.erikjhordanrey.cleanarchitecture.data.repository.datasource.TeamsLocalDataSource;
import io.reactivex.rxjava3.core.Observable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TeamsRepositoryTest {

    private static final String ANY_FLAG_OF_TEAM_ENTITY = "ESP";

    @Mock
    private TeamsLocalDataSource teamsLocalDataSource;

    private TeamsRepository teamsRepository;

    @Before
    public void setUp() {
        teamsRepository = new TeamsRepository(teamsLocalDataSource, new TeamEntityToTeamMapper());
    }

    @Test
    public void givenATeamEntityListFromLocalApi() {
        given(teamsLocalDataSource.teamEntityList()).willReturn(Observable.just(FakeTeamLocalAPI.getFakeTeamEntityList()));

        teamsRepository.getTeamList();

        verify(teamsLocalDataSource).teamEntityList();
    }

    @Test
    public void givenATeamEntityByFlagFromLocalApi() {
        given(teamsLocalDataSource.teamEntity(ANY_FLAG_OF_TEAM_ENTITY)).willReturn(Observable.just(FakeTeamLocalAPI.getFakeTeamEntity()));

        teamsRepository.getTeam(ANY_FLAG_OF_TEAM_ENTITY);

        verify(teamsLocalDataSource).teamEntity(ANY_FLAG_OF_TEAM_ENTITY);
    }
}
