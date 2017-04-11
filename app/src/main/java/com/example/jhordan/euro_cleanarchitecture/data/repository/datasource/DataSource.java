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

import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import io.reactivex.Observable;
import java.util.List;

/**
 * Represents a data store where data is retrieved.
 */
public interface DataSource {

  /**
   * Get an 'Observable<List<TeamEntity>>'  which will emit a List of {@link TeamEntity}.
   */
  Observable<List<TeamEntity>> teamEntityList();

  /**
   * Get an  'Observable<TeamEntity>' which will emit a {@link TeamEntity} by its flag.
   *
   * @param flag The flag to retrieve team data.
   */

  Observable<TeamEntity> teamEntity(final String flag);
}
