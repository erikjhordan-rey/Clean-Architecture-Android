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

package com.example.jhordan.euro_cleanarchitecture.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamEntity {

  @SerializedName("flag") private String teamFlag;
  @SerializedName("name") private String teamName;
  @SerializedName("images") private List<ImageEntity> images;
  @SerializedName("team_declaimer") private String disclaimer;
  @SerializedName("best_result") private String bestResult;
  @SerializedName("coach") private String coach;
  @SerializedName("leading_scorer") private String leadingScorer;
  @SerializedName("nick_name") private String nickName;
  @SerializedName("stadium") private String stadium;
  @SerializedName("description_part_1") private String getdescription1;
  @SerializedName("matches_played") private String matchesPlayed;
  @SerializedName("overall") private String teamOverall;
  @SerializedName("final_tournament") private String finalTournament;
  @SerializedName("description_part_2") private String getDescription2;
  @SerializedName("description_part_3") private String getDescription3;

  public String getTeamFlag() {
    return teamFlag;
  }

  public void setTeamFlag(String teamFlag) {
    this.teamFlag = teamFlag;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public List<ImageEntity> getImages() {
    return images;
  }

  public void setImages(List<ImageEntity> images) {
    this.images = images;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public String getBestResult() {
    return bestResult;
  }

  public String getCoach() {
    return coach;
  }

  public String getLeadingScorer() {
    return leadingScorer;
  }

  public String getNickName() {
    return nickName;
  }

  public String getStadium() {
    return stadium;
  }

  public String getGetdescription1() {
    return getdescription1;
  }

  public String getMatchesPlayed() {
    return matchesPlayed;
  }

  public String getTeamOverall() {
    return teamOverall;
  }

  public String getFinalTournament() {
    return finalTournament;
  }

  public String getGetDescription2() {
    return getDescription2;
  }

  public String getGetDescription3() {
    return getDescription3;
  }
}
