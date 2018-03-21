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
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.DataSource;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamDataSourceFactory;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper.TeamToTeamEntityMapper;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class TeamsRepository implements Repository {

  private final TeamToTeamEntityMapper teamToTeamEntityMapper;
  private final DataSource dataSource;

  @Inject TeamsRepository(@NonNull TeamDataSourceFactory teamDataSourceFactory,
      @NonNull TeamToTeamEntityMapper teamToTeamEntityMapper) {
    this.teamToTeamEntityMapper = teamToTeamEntityMapper;
    this.dataSource = teamDataSourceFactory.createDataSource();
  }

  @Override public Observable<List<Team>> teamList() {
    return dataSource.teamEntityList().map(teamToTeamEntityMapper::reverseMap);
  }

  @Override public Observable<Team> team(String flag) {
    return dataSource.teamEntity(flag).map(teamToTeamEntityMapper::reverseMap);
  }

}
