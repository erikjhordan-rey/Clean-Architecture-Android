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

package io.github.erikjhordanrey.cleanarchitecture.view.model.mapper;

import io.github.erikjhordanrey.cleanarchitecture.core.mapper.Mapper;
import io.github.erikjhordanrey.cleanarchitecture.domain.model.Team;
import io.github.erikjhordanrey.cleanarchitecture.view.model.TeamUi;
import javax.inject.Inject;

public class TeamToTeamUiMapper extends Mapper<Team, TeamUi> {

    @Inject
    public TeamToTeamUiMapper() {
    }

    @Override
    public TeamUi map(Team value) {
        final TeamUi teamUi = new TeamUi();
        teamUi.setFlag(value.getFlag());
        teamUi.setName(value.getName());
        teamUi.setPictureOfFlag(value.getImageFlag());
        teamUi.setPictureOfProfile(value.getImageProfile());
        teamUi.setPictureOfHeader(value.getImageHeader());
        teamUi.setPictureOfDetail(value.getImageDetail());
        teamUi.setDisclaimer(value.getDisclaimer());
        teamUi.setBestResult(value.getBestResult());
        teamUi.setCoach(value.getCoach());
        teamUi.setLeadingScorer(value.getLeadingScorer());
        teamUi.setNickName(value.getNickName());
        teamUi.setStadium(value.getStadium());
        teamUi.setDescriptionPart1(value.getDescriptionPart1());
        teamUi.setMatchesPlayed(value.getMatchesPlayed());
        teamUi.setOverall(value.getOverall());
        teamUi.setFinalTournament(value.getFinalTournament());
        teamUi.setDescriptionPart2(value.getDescriptionPart2());
        teamUi.setDescriptionPart3(value.getDescriptionPart3());
        return teamUi;
    }

    @Override
    public Team reverseMap(TeamUi value) {
        throw new UnsupportedOperationException();
    }
}
