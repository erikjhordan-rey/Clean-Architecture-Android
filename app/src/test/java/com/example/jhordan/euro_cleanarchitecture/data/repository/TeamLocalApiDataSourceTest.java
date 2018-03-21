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

import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.example.jhordan.euro_cleanarchitecture.data.local.LocalApi;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamsLocalApiDataSource;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class) public class TeamLocalApiDataSourceTest {

  private static final String ANY_FLAG_OF_TEAM_ENTITY = "ESP";

  @Mock private LocalApi localApi;

  private TeamsLocalApiDataSource localApiDataSource;

  @Before public void setUp() {
    localApiDataSource = new TeamsLocalApiDataSource(localApi);
  }

  @Test public void givenATeamEntityListFromLocalApi() {
    localApiDataSource.teamEntityList();
    verify(localApi).teamEntityList();
  }

  @Test public void givenATeamEntityByFlagFromLocalApi() {
    localApiDataSource.teamEntity(ANY_FLAG_OF_TEAM_ENTITY);
    verify(localApi).teamEntity(ANY_FLAG_OF_TEAM_ENTITY);
  }

  @Test public void givenAnObservableCollectionTeamEntity() {
    List<TeamEntity> teamEntities = new ArrayList<>();
    Observable<List<TeamEntity>> fakeListObservable = Observable.just(teamEntities);
    given(localApi.teamEntityList()).willReturn(fakeListObservable);
  }

  @Test public void givenAnObservableTeamEntity() {
    TeamEntity fakeEntity = new TeamEntity();
    Observable<TeamEntity> fakeObservable = Observable.just(fakeEntity);
    given(localApi.teamEntity(ANY_FLAG_OF_TEAM_ENTITY)).willReturn(fakeObservable);
  }
}
