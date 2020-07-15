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

package io.github.erikjhordanrey.cleanarchitecture.domain;

import io.github.erikjhordanrey.cleanarchitecture.data.repository.TeamsRepository;
import io.github.erikjhordanrey.cleanarchitecture.domain.usecase.GetTeamUseCase;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetTeamUseCaseTest {

    private static final String ANY_FLAG_OF_EURO_TEAMS = "ESP";

    @Mock
    private TeamsRepository repository;

    private GetTeamUseCase getTeamUseCase;

    @Before
    public void setup() {
        getTeamUseCase = givenATeamByFlagUseCase();
    }

    @Test
    public void givenAConcreteUseCaseOfGetEuroTeamByFlag() {
        assertThat(getTeamUseCase, instanceOf(GetTeamUseCase.class));
    }

    @Test
    public void getTeamByFlagObservableFromRepository() {
        getTeamUseCase.getTeam(ANY_FLAG_OF_EURO_TEAMS);

        verify(repository).getTeam(ANY_FLAG_OF_EURO_TEAMS);
        verifyNoMoreInteractions(repository);
    }

    private GetTeamUseCase givenATeamByFlagUseCase() {
        return new GetTeamUseCase(repository);
    }
}
