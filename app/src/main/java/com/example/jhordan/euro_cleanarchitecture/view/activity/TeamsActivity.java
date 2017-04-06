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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.Bind;
import com.example.jhordan.euro_cleanarchitecture.EuroApplication;
import com.example.jhordan.euro_cleanarchitecture.R;
import com.example.jhordan.euro_cleanarchitecture.data.repository.TeamsRepository;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.TeamDataSourceFactory;
import com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper.TeamToTeamEntityMapper;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetEuroTeams;
import com.example.jhordan.euro_cleanarchitecture.view.adapter.TeamsAdapter;
import com.example.jhordan.euro_cleanarchitecture.view.base.view.BaseActivity;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.mapper.TeamViewModelToTeamMapper;
import com.example.jhordan.euro_cleanarchitecture.view.widget.DividerItemDecoration;
import java.util.List;
import javax.inject.Inject;

public class TeamsActivity extends BaseActivity implements TeamsPresenter.View {

  @Inject TeamsPresenter presenter;
  private TeamsAdapter adapter;

  @Bind(R.id.list_teams) RecyclerView teamList;
  @Bind(R.id.progress_team) ProgressBar teamProgress;


  @Override public void initView() {
    super.initView();
    initializeDagger();
    initializePresenter();
    disableTitleFromToolbar();
    initializeAdapter();
    initializeRecyclerView();
    presenter.initialize();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_teams;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_scrolling, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.action_code) {
      final String repositoryURL = "https://erikcaffrey.github.io/2016/01/28/clean-architecture/";
      startActivityActionView(repositoryURL);
    } else {
      String blogURL = "";
      startActivityActionView(blogURL);
    }

    return super.onOptionsItemSelected(item);
  }

  @Override public void showEuroTeams(List<TeamViewModel> teamList) {
    adapter.addAll(teamList);
    adapter.notifyDataSetChanged();
  }

  @Override public void openTeamScreen(TeamViewModel team) {
    TeamDetailsActivity.open(TeamsActivity.this, team.getFlag());
  }

  @Override public void showLoading() {
    teamProgress.setVisibility(View.VISIBLE);
    teamList.setVisibility(View.GONE);
  }

  @Override public void hideLoading() {
    teamProgress.setVisibility(View.GONE);
    teamList.setVisibility(View.VISIBLE);
  }

  private void initializeAdapter() {
    adapter = new TeamsAdapter(presenter);
  }

  private void initializeRecyclerView() {
    teamList.setLayoutManager(new LinearLayoutManager(this));
    teamList.addItemDecoration(
        new DividerItemDecoration(TeamsActivity.this, DividerItemDecoration.VERTICAL_LIST));
    teamList.setHasFixedSize(true);
    teamList.setAdapter(adapter);
  }

  private void initializeDagger() {
    EuroApplication app = (EuroApplication) getApplication();
    app.getMainComponent().inject(this);
  }

  private void initializePresenter() {
    presenter.setView(this);
  }

  private void disableTitleFromToolbar() {
    if (getSupportActionBar() != null) getSupportActionBar().setDisplayShowTitleEnabled(false);
  }

  private void startActivityActionView(String url) {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
  }
}
