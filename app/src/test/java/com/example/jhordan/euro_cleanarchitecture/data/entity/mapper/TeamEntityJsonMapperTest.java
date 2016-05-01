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

package com.example.jhordan.euro_cleanarchitecture.data.entity.mapper;

import com.example.jhordan.euro_cleanarchitecture.ApplicationTestCase;
import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.example.jhordan.euro_cleanarchitecture.data.entity.mapper.data.FakeTeamLocalAPI;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper.TeamEntityJsonMapper;
import com.google.gson.JsonSyntaxException;
import java.util.Collection;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamEntityJsonMapperTest extends ApplicationTestCase {

  private TeamEntityJsonMapper teamEntityJsonMapper;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Before public void setUp() {
    teamEntityJsonMapper = new TeamEntityJsonMapper();
  }

  @Test public void givenTransformCollectionTeamEntityCorrectly() {
    final String FAKE_JSON_RESPONSE_TEAM_COLLECTION =
        FakeTeamLocalAPI.getJsonResponseTeamCollection();
    Collection<TeamEntity> teamEntities =
        teamEntityJsonMapper.transformTeamEntityCollection(FAKE_JSON_RESPONSE_TEAM_COLLECTION);
    final TeamEntity teamEntityOne = ((TeamEntity) teamEntities.toArray()[0]);
    final TeamEntity teamEntityTwo = ((TeamEntity) teamEntities.toArray()[1]);
    final TeamEntity teamEntityThree = ((TeamEntity) teamEntities.toArray()[2]);
    assertThat(teamEntityOne.getTeamFlag(), is("ALB"));
    assertThat(teamEntityTwo.getTeamFlag(), is("AUT"));
    assertThat(teamEntityThree.getTeamFlag(), is("BEL"));
    assertThat(teamEntities.size(), is(3));
  }

  @Test public void givenTransformTeamEntityCorrectly() {
    final String FAKE_JSON_RESPONSE_TEAM = FakeTeamLocalAPI.getJsonResponseTeam();
    TeamEntity teamEntity = teamEntityJsonMapper.transformTeamEntity(FAKE_JSON_RESPONSE_TEAM);
    assertThat(teamEntity.getTeamFlag(), is("ALB"));
    assertThat(teamEntity.getTeamName(), is("Albania"));
    //you can try test each attribute is possible
  }

  @Test public void givenExpectedExceptionTransformUserEntityCollectionNotValidResponse() {
    expectedException.expect(JsonSyntaxException.class);
    teamEntityJsonMapper.transformTeamEntityCollection("Expects a json array like response");
  }

  @Test public void givenExpectedExceptionTransformUserEntityNotValidResponse() {
    expectedException.expect(JsonSyntaxException.class);
    teamEntityJsonMapper.transformTeamEntity("Expects a json object like response");
  }
}
