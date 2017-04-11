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

package com.example.jhordan.euro_cleanarchitecture.data.repository;

import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import io.reactivex.Observable;
import java.util.List;


public interface Repository {
  /**
   * Get an 'Observable<List<Team>>'  which will emit a List of {@link Team}.
   */
  Observable<List<Team>> teamList();

  /**
   * Get an  'Observable<Team>' which will emit a {@link Team} by its flag.
   *
   * @param flag The flag to retrieve team data.
   */

  Observable<Team> team(final String flag);
}
