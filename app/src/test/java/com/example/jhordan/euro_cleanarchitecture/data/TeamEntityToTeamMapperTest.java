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

package com.example.jhordan.euro_cleanarchitecture.data;

import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.example.jhordan.euro_cleanarchitecture.fake.FakeTeamLocalAPI;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamEntityToTeamMapper;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TeamEntityToTeamMapperTest {

    private final static String FAKE_TEAM_FLAG = "ALB";
    private final static String FAKE_TEAM_NAME = "Albania";
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private TeamEntityToTeamMapper teamEntityToTeamMapper;

    @Before
    public void setUp() {
        teamEntityToTeamMapper = new TeamEntityToTeamMapper();
    }

    @Test
    public void givenTransformTeamEntityToTeam() throws Exception {
        TeamEntity teamEntity = FakeTeamLocalAPI.getFakeTeamEntity();
        Team team = teamEntityToTeamMapper.map(teamEntity);
        assertThat(team, is(instanceOf(Team.class)));
        assertThat(team.getFlag(), is(FAKE_TEAM_FLAG));
        assertThat(team.getName(), is(FAKE_TEAM_NAME));
    }

    @Test
    public void givenExpectedExceptionTransformUserEntityCollectionNotValidResponse() {
        expectedException.expect(UnsupportedOperationException.class);
        teamEntityToTeamMapper.reverseMap(new Team());
    }
}
