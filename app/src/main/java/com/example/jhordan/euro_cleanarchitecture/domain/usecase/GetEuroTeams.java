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

package com.example.jhordan.euro_cleanarchitecture.domain.usecase;

import com.example.jhordan.euro_cleanarchitecture.data.repository.Repository;
import com.example.jhordan.euro_cleanarchitecture.domain.model.Team;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class GetEuroTeams extends UseCase<List<Team>> {

  private final Repository teamsRepository;

  @Inject public GetEuroTeams(@Named("executor_thread") Scheduler executorThread,
      @Named("ui_thread") Scheduler uiThread, Repository teamsRepository) {
    super(executorThread, uiThread);
    this.teamsRepository = teamsRepository;
  }

  @Override public Observable<List<Team>> createObservableUseCase() {
    return this.teamsRepository.teamList();
  }
}
