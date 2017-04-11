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
import com.example.jhordan.euro_cleanarchitecture.data.local.LocalApi;
import io.reactivex.Observable;
import java.util.List;


/**
 * {@link DataSource} implementation based on read local json file from assets (euro_data.json).
 */
public class TeamsLocalApiDataSource implements DataSource {

  private final LocalApi localApi;

  public TeamsLocalApiDataSource(LocalApi localApi) {
    this.localApi = localApi;
  }

  @Override public Observable<List<TeamEntity>> teamEntityList() {
    return this.localApi.teamEntityList();
  }

  @Override public Observable<TeamEntity> teamEntity(String flag) {
    return this.localApi.teamEntity(flag);
  }
}
