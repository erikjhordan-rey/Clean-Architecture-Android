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

package com.example.jhordan.euro_cleanarchitecture.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper.TeamEntityJsonMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import io.reactivex.Observable;

public class LocalImpl implements LocalApi {

  private final Context context;
  private final TeamEntityJsonMapper teamEntityJsonMapper;

  public LocalImpl(@NonNull Context context, @NonNull TeamEntityJsonMapper teamEntityJsonMapper) {
    this.context = context;
    this.teamEntityJsonMapper = teamEntityJsonMapper;
  }

  @Override public Observable<List<TeamEntity>> teamEntityList() {
    return Observable.create(emitter -> {
      List<TeamEntity> teamEntityList = getAll();
      if (teamEntityList != null) {
        emitter.onNext(teamEntityList);
        emitter.onComplete();
      } else {
        emitter.onError(
            new Throwable("Error getting team data list from the local json (euro_data.json)"));
      }
    });
  }

  @Override public Observable<TeamEntity> teamEntity(final String flag) {
    return Observable.create(emitter -> {
      TeamEntity teamEntity = getByFlag(flag);
      if (teamEntity != null) {
        emitter.onNext(teamEntity);
        emitter.onComplete();
      } else {
        emitter.onError(
            new Throwable("Error getting team data by flag from the local json (euro_data.json)"));
      }
    });
  }

  private List<TeamEntity> getAll() {
    return teamEntityJsonMapper.transformTeamEntityCollection(getResponseFromLocalJson());
  }

  private TeamEntity getByFlag(String flag) {
    TeamEntity result = null;
    for (TeamEntity entity : getAll()) {
      if (entity.getTeamFlag().equals(flag)) {
        result = entity;
        break;
      }
    }
    return result;
  }

  private String getResponseFromLocalJson() {
    final String EURO_DATA_FILE = "euro_data.json";
    String str = "";
    try {
      StringBuilder builder = new StringBuilder();
      InputStream json = context.getAssets().open(EURO_DATA_FILE);
      BufferedReader in = new BufferedReader(new InputStreamReader(json));

      while ((str = in.readLine()) != null) {
        builder.append(str);
      }
      in.close();
      str = builder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }
}
