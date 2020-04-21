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

import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

public class LocalTeamApiToTeamEntityMapper {

    private final Gson gson;

    @Inject
    public LocalTeamApiToTeamEntityMapper(Gson gson) {
        this.gson = gson;
    }

    public TeamEntity transformTeamEntity(String teamJsonResponse) throws JsonSyntaxException {
        try {
            final Type typeTeamEntity = new TypeToken<TeamEntity>() {
            }.getType();
            return gson.fromJson(teamJsonResponse, typeTeamEntity);
        } catch (JsonSyntaxException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public List<TeamEntity> transformTeamEntityCollection(String teamListJsonResponse) throws JsonSyntaxException {
        try {
            final Type typeTeamEntityList = new TypeToken<List<TeamEntity>>() {
            }.getType();
            return gson.fromJson(teamListJsonResponse, typeTeamEntityList);
        } catch (JsonSyntaxException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }
}
