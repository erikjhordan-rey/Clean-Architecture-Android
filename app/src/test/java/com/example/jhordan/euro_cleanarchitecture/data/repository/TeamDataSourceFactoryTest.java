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

import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.DataSource;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamDataSourceFactory;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamsLocalApiDataSource;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamDataSourceFactoryTest {
  private TeamDataSourceFactory teamDataSourceFactory;

  @Before public void setUp() {
    teamDataSourceFactory = new TeamDataSourceFactory(RuntimeEnvironment.application);
  }

  @Test public void givenAnInstanceTeamsLocalApiDataSource() {
    DataSource dataSource = teamDataSourceFactory.createDataSource();
    assertThat(dataSource, is(notNullValue()));
    assertThat(dataSource, is(instanceOf(TeamsLocalApiDataSource.class)));
  }
}
