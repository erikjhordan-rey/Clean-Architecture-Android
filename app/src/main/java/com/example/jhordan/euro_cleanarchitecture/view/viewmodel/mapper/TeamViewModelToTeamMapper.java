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

package com.example.jhordan.euro_cleanarchitecture.view.viewmodel.mapper;

import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper.Mapper;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import javax.inject.Inject;

public class TeamViewModelToTeamMapper extends Mapper<TeamViewModel, Team> {

  @Inject public TeamViewModelToTeamMapper(){}

  @Override public Team map(TeamViewModel value) {
    throw new UnsupportedOperationException();
  }

  @Override public TeamViewModel reverseMap(Team value) {
    TeamViewModel teamViewModel = new TeamViewModel();
    teamViewModel.setFlag(value.getFlag());
    teamViewModel.setName(value.getName());
    teamViewModel.setPictureOfFlag(value.getImageFlag());
    teamViewModel.setPictureOfProfile(value.getImageProfile());
    teamViewModel.setPictureOfHeader(value.getImageHeader());
    teamViewModel.setPictureOfDetail(value.getImageDetail());
    teamViewModel.setDisclaimer(value.getDisclaimer());
    teamViewModel.setBestResult(value.getBestResult());
    teamViewModel.setCoach(value.getCoach());
    teamViewModel.setLeadingScorer(value.getLeadingScorer());
    teamViewModel.setNickName(value.getNickName());
    teamViewModel.setStadium(value.getStadium());
    teamViewModel.setDescriptionPart1(value.getDescriptionPart1());
    teamViewModel.setMatchesPlayed(value.getMatchesPlayed());
    teamViewModel.setOverall(value.getOverall());
    teamViewModel.setFinalTournament(value.getFinalTournament());
    teamViewModel.setDescriptionPart2(value.getDescriptionPart2());
    teamViewModel.setDescriptionPart3(value.getDescriptionPart3());
    return teamViewModel;
  }
}
