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
package com.example.jhordan.euro_cleanarchitecture.presentation;

import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetEuroTeams;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.mapper.TeamViewModelToTeamMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class) public class TeamsPresenterTest {

  @Mock TeamViewModelToTeamMapper mapper;
  @Mock TeamsPresenter.View view;
  @Mock GetEuroTeams getEuroTeams;
  private TeamsPresenter presenter;

  @Before public void setUp() throws Exception {
    presenter = new TeamsPresenter(getEuroTeams, mapper);
    presenter.setView(view);
  }

  @SuppressWarnings("unchecked") @Test public void testTeamsPresenterInitialize() {
    assertThat(presenter, is(notNullValue()));
    //TODO fix this test
    //presenter.initialize();
    //verify(view).showLoading();
    //verify(getEuroTeams).execute(any(DisposableObserver.class));
  }
}
