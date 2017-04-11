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

package com.example.jhordan.euro_cleanarchitecture.domain;

import com.example.jhordan.euro_cleanarchitecture.data.repository.TeamsRepository;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetEuroTeamByFlag;
import io.reactivex.schedulers.Schedulers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class) public class GetEuroTeamByFlagTest {

  private static final String ANY_FLAG_OF_EURO_TEAMS = "ESP";
  @Mock TeamsRepository repository;
  private GetEuroTeamByFlag getEuroTeamByFlag;

  @Before public void setup() {
    getEuroTeamByFlag = givenATeamByFlagUseCase();
  }

  @Test public void givenAConcreteUseCaseOfGetEuroTeamByFlag() {
    assertThat(getEuroTeamByFlag, instanceOf(GetEuroTeamByFlag.class));
  }

  @Test public void getTeamByFlagObservableFromRepository() {
    getEuroTeamByFlag.searchTeamByFlag(ANY_FLAG_OF_EURO_TEAMS);
    getEuroTeamByFlag.createObservableUseCase();
    Mockito.verify(repository).team(ANY_FLAG_OF_EURO_TEAMS);
    Mockito.verifyNoMoreInteractions(repository);
  }

  private GetEuroTeamByFlag givenATeamByFlagUseCase() {
    return new GetEuroTeamByFlag(Schedulers.trampoline(), Schedulers.trampoline(), repository);
  }
}
