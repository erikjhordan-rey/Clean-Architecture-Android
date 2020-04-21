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

import com.example.jhordan.euro_cleanarchitecture.core.Mapper;
import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class TeamEntityToTeamMapper extends Mapper<Team, TeamEntity> {

  @Inject public TeamEntityToTeamMapper() {
  }

  @Override public TeamEntity map(Team value) {
    throw new UnsupportedOperationException();
  }

  @Override public Team reverseMap(TeamEntity value) {
    Team team = new Team();
    team.setFlag(value.getTeamFlag());
    team.setName(value.getTeamName());
    team.setImageFlag(value.getImages().get(0).getImageFlag());
    team.setImageProfile(value.getImages().get(0).getImageProfile());
    team.setImageHeader(value.getImages().get(0).getImageHeader());
    team.setImageDetail(value.getImages().get(0).getImageDetail());
    team.setDisclaimer(value.getDisclaimer());
    team.setBestResult(value.getBestResult());
    team.setCoach(value.getCoach());
    team.setLeadingScorer(value.getLeadingScorer());
    team.setNickName(value.getNickName());
    team.setStadium(value.getStadium());
    team.setDescriptionPart1(value.getFirstDescription());
    team.setMatchesPlayed(value.getMatchesPlayed());
    team.setOverall(value.getTeamOverall());
    team.setFinalTournament(value.getFinalTournament());
    team.setDescriptionPart2(value.getSecondDescription());
    team.setDescriptionPart3(value.getThirdDescription());
    return team;
  }
}
