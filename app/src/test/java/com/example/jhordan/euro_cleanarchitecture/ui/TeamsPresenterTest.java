package com.example.jhordan.euro_cleanarchitecture.ui;

import com.example.jhordan.euro_cleanarchitecture.RxAndroidRule;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetTeamsUseCase;
import com.example.jhordan.euro_cleanarchitecture.fake.FakeTeamLocalAPI;
import com.example.jhordan.euro_cleanarchitecture.view.model.mapper.TeamToTeamUiMapper;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import io.reactivex.Observable;
import java.util.Collections;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.BDDMockito.given;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TeamsPresenterTest {

    @ClassRule public static RxAndroidRule blockingRxAndroidTestRule = new RxAndroidRule();

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private TeamsPresenter.View view;
    @Mock private GetTeamsUseCase getTeamsUseCase;
    @Mock private TeamToTeamUiMapper teamToTeamUiMapper;

    private TeamsPresenter teamsPresenter;

    @Before
    public void setUp() {
        teamsPresenter = new TeamsPresenter(getTeamsUseCase, teamToTeamUiMapper);
        teamsPresenter.setView(view);
    }

    @Test
    public void showTeamsWhenRetrieveTeamsSuccessfully() {
        given(getTeamsUseCase.getTeamList()).willReturn(Observable.just(FakeTeamLocalAPI.getFakeTeamList()));

        teamsPresenter.initialize();

        InOrder order = Mockito.inOrder(view);
        order.verify(view).showLoading();
        order.verify(view).showEuroTeams(Collections.emptyList());
        order.verify(view).hideLoading();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void showErrorWhenRetrieveTeamsFails() {
        given(getTeamsUseCase.getTeamList()).willReturn(Observable.error(new Throwable("Error getting teams")));

        teamsPresenter.initialize();

        InOrder order = Mockito.inOrder(view);
        order.verify(view).showLoading();
        order.verify(view).hideLoading();
        verifyNoMoreInteractions(view);
    }
}
