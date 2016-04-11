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

import android.support.annotation.NonNull;
import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.DataSource;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper.TeamToTeamEntityMapper;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.functions.Func1;

@Singleton public class TeamsRepository implements Repository {

  private final TeamToTeamEntityMapper teamToTeamEntityMapper;
  private final DataSource dataSource;

  @Inject public TeamsRepository(@NonNull TeamDataSourceFactory teamDataSourceFactory, @NonNull TeamToTeamEntityMapper teamToTeamEntityMapper) {
    this.teamToTeamEntityMapper = teamToTeamEntityMapper;
    this.dataSource = teamDataSourceFactory.createDataSource();
  }

  @Override public Observable<List<Team>> teamList() {
    return dataSource.teamEntityList().map(new Func1<List<TeamEntity>, List<Team>>() {
      @Override public List<Team> call(List<TeamEntity> teamEntities) {
        return teamToTeamEntityMapper.reverseMap(teamEntities);
      }
    });
  }

  @Override public Observable<Team> team(String flag) {
    return dataSource.teamEntity(flag).map(new Func1<TeamEntity, Team>() {
      @Override public Team call(TeamEntity teamEntity) {
        return teamToTeamEntityMapper.reverseMap(teamEntity);
      }
    });
  }

}
