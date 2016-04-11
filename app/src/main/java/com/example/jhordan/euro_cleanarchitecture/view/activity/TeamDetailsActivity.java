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

package com.example.jhordan.euro_cleanarchitecture.view.activity;

import android.content.Context;
import android.content.Intent;
import com.example.jhordan.euro_cleanarchitecture.EuroApplication;
import com.example.jhordan.euro_cleanarchitecture.R;
import com.example.jhordan.euro_cleanarchitecture.view.base.view.BaseActivity;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamDetailPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import javax.inject.Inject;

public class TeamDetailsActivity extends BaseActivity implements TeamDetailPresenter.View {

  private final static String TEAM_FLAG_KEY = "team_flag_key";

  @Inject TeamDetailPresenter presenter;

  @Override public void initView() {
    super.initView();
    initializeDagger();
    initializePresenter();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_team_detail;
  }

  private void initializeDagger() {
    EuroApplication euroApplication = (EuroApplication) getApplication();
    euroApplication.getMainComponent().inject(this);
  }

  private void initializePresenter() {
    presenter.setView(this);
    String flag = getTeamFlagKey();
    presenter.setTeamFlag(flag);
    presenter.initialize();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  public static void open(Context context, String superHeroName) {
    Intent intent = new Intent(context, TeamDetailsActivity.class);
    intent.putExtra(TEAM_FLAG_KEY, superHeroName);
    context.startActivity(intent);
  }

  private String getTeamFlagKey() {
    return getIntent().getExtras().getString(TEAM_FLAG_KEY);
  }

  @Override public void showTeam(TeamViewModel teamViewModel) {
    System.out.println(teamViewModel.getName());
  }

  @Override public void showLoading() {
    // I´m thinking...
  }

  @Override public void hideLoading() {
    // I´m thinking...
  }
}
