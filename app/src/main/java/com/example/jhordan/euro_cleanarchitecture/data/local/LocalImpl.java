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
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class LocalImpl implements LocalApi {

  private final Context context;
  private final TeamEntityJsonMapper teamEntityJsonMapper;
  List<TeamEntity> teamEntityList;

  public LocalImpl(@NonNull Context context, @NonNull TeamEntityJsonMapper teamEntityJsonMapper) {
    this.context = context;
    this.teamEntityJsonMapper = teamEntityJsonMapper;
  }

  @Override public Observable<List<TeamEntity>> teamEntityList() {
    return Observable.create(new Observable.OnSubscribe<List<TeamEntity>>() {
      @Override public void call(Subscriber<? super List<TeamEntity>> subscriber) {
        List<TeamEntity> teamEntityList = getAll();
        if (teamEntityList != null) {
          subscriber.onNext(teamEntityList);
          subscriber.onCompleted();
        } else {
          subscriber.onError(
              new Throwable("Error getting team data list from the local json (euro_data.json)"));
        }
      }
    });
  }

  @Override public Observable<TeamEntity> teamEntity(final String flag) {
    return Observable.create(new Observable.OnSubscribe<TeamEntity>() {
      @Override public void call(Subscriber<? super TeamEntity> subscriber) {
        TeamEntity teamEntity = getByFlag(flag);
        if (teamEntity != null) {
          subscriber.onNext(teamEntity);
          subscriber.onCompleted();
        } else {
          subscriber.onError(new Throwable(
              "Error getting team data by flag from the local json (euro_data.json)"));
        }
      }
    });
  }

  /**
   * This method works to obtain a collection of data {@link TeamEntity}.
   */
  //public List<TeamEntity> getAll() {
  //
  //  getTeamEntityList().subscribe(new Action1<List<TeamEntity>>() {
  //    @Override public void call(List<TeamEntity> teamEntities) {
  //      teamEntityList = teamEntities;
  //    }
  //  }, new Action1<Throwable>() {
  //    @Override public void call(Throwable throwable) {
  //      throwable.printStackTrace();
  //    }
  //  });
  //
  //  for (TeamEntity team : teamEntityList)
  //    System.out.println(team.getTeamName());
  //  return teamEntityList;
  //}

  public List<TeamEntity> getAll() {

    System.out.println(getResponseFromLocalJson());
    return teamEntityJsonMapper.transformTeamEntityCollection(getResponseFromLocalJson());
  }

  /**
   * This method works to obtain a TeamEntity  {@link TeamEntity}  by its flag.
   */
  public TeamEntity getByFlag(String flag) {
    TeamEntity result = null;
    for (TeamEntity entity : getAll()) {
      if (entity.getTeamFlag().equals(flag)) {
        result = entity;
        break;
      }
    }
    return result;
  }

  /**
   * This methods works to read a local JSON (euro_data.json) from assets.
   */

  //private String getResponseFromLocalJson() {
  //  byte[] buffer = null;
  //  try {
  //    final String EURO_DATA_FILE = "euro_data.json";
  //    InputStream is = context.getAssets().open(EURO_DATA_FILE);
  //
  //    int size = is.available();
  //    buffer = new byte[size];
  //    is.read(buffer);
  //    is.close();
  //  } catch (IOException e) {
  //    e.printStackTrace();
  //  }
  //  assert buffer != null;
  //  return new String(buffer);
  //}
  private Observable<List<TeamEntity>> getTeamEntityList() {
    return Observable.create(new Observable.OnSubscribe<List<TeamEntity>>() {
      @Override public void call(Subscriber<? super List<TeamEntity>> subscriber) {
        String file = getResponseFromLocalJson();
        List<TeamEntity> teamEntityList = teamEntityJsonMapper.transformTeamEntityCollection(file);
        subscriber.onNext(teamEntityList);
        subscriber.onCompleted();
      }
    });
  }


  private String getResponseFromLocalJson(){
    String str = "";
    try{
      StringBuilder builder = new StringBuilder();
      InputStream json= context.getAssets().open("euro_data.json");
      BufferedReader in= new BufferedReader(new InputStreamReader(json));

      while ((str=in.readLine()) != null) {
        builder.append(str);
      }
      in.close();
      str = builder.toString();
    }catch (IOException e){
      e.printStackTrace();
    }


    return str;
  }

  //private String getResponseFromLocalJson() {
  //  String response = "";
  //  try {
  //    InputStreamReader inputStreamReader = getEuroDataJson();
  //    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
  //    response = getStringBuilder(bufferedReader);
  //  } catch (IOException exception) {
  //    exception.printStackTrace();
  //  }
  //  return response;
  //}
  //
  //private InputStreamReader getEuroDataJson() throws IOException {
  //  final String EURO_DATA_FILE = "euro_data.json";
  //  return new InputStreamReader(context.getAssets().open(EURO_DATA_FILE));
  //}
  //
  //private String getStringBuilder(BufferedReader bufferedReader) throws IOException {
  //  StringBuilder builder = new StringBuilder();
  //  String line = bufferedReader.readLine();
  //  while (line != null) {
  //    builder.append(line);
  //  }
  //  bufferedReader.close();
  //  return builder.toString();
  //}
}
