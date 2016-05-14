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

import android.content.Context;
import android.support.annotation.NonNull;
import com.example.jhordan.euro_cleanarchitecture.data.local.LocalImpl;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamsLocalApiDataSource;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper.TeamEntityJsonMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

/*
 * you can create other places where retrieve data and here you
 * will write the logic to know what origin data you should use.
 */
@Singleton public class TeamDataSourceFactory {

  private final Context context;

  @Inject public TeamDataSourceFactory(@NonNull Context context) {
    this.context = context;
  }

  public TeamsLocalApiDataSource createDataSource() {
    TeamEntityJsonMapper teamEntityJsonMapper = new TeamEntityJsonMapper();
    LocalImpl local = new LocalImpl(context, teamEntityJsonMapper);
    return new TeamsLocalApiDataSource(local);
  }
}
