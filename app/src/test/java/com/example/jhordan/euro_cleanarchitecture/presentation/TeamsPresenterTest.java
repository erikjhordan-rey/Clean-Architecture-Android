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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import rx.Subscriber;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class) public class TeamsPresenterTest {

  @Mock GetEuroTeams getEuroTeams;
  @Mock TeamViewModelToTeamMapper mapper;
  @Mock TeamsPresenter.View view;

  private TeamsPresenter presenter;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    presenter = new TeamsPresenter(getEuroTeams, mapper);
    presenter.setView(view);
  }

  @Test public void testTeamsPresenterInitialize() {
    assertThat(presenter, is(notNullValue()));
    presenter.initialize();
    verify(view).showLoading();
    verify(getEuroTeams).execute(any(Subscriber.class));
  }
}
