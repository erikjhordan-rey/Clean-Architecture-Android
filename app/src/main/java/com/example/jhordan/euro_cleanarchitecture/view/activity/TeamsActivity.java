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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.jhordan.euro_cleanarchitecture.EuroApplication;
import com.example.jhordan.euro_cleanarchitecture.R;
import com.example.jhordan.euro_cleanarchitecture.databinding.ActivityTeamsBinding;
import com.example.jhordan.euro_cleanarchitecture.view.adapter.TeamsAdapter;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import java.util.List;
import javax.inject.Inject;

public class TeamsActivity extends AppCompatActivity implements TeamsPresenter.View {

    private final static String REPOSITORY_URL = "https://github.com/erikjhordan-rey/Clean-Architecture-Android";
    private final static String BLOG_URL = "https://erikjhordan-rey.github.io/blog/2016/01/27/ANDROID-clean-architecture.html";

    private ActivityTeamsBinding binding;
    private TeamsAdapter adapter;

    @Inject
    TeamsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeamsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializeToolbar();
        initializeDagger();
        initializePresenter();
        initializeAdapter();
        initializeRecyclerView();
        presenter.initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivityActionView((R.id.action_code == item.getItemId()) ? REPOSITORY_URL : BLOG_URL);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showEuroTeams(List<TeamUi> teamList) {
        adapter.addAll(teamList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openTeamScreen(TeamUi team) {
        TeamDetailActivity.open(TeamsActivity.this, team.getFlag());
    }

    @Override
    public void showLoading() {
        binding.contentTeams.progressTeam.setVisibility(View.VISIBLE);
        binding.contentTeams.listTeams.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        binding.contentTeams.progressTeam.setVisibility(View.GONE);
        binding.contentTeams.listTeams.setVisibility(View.VISIBLE);
    }

    private void initializeToolbar() {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void initializeDagger() {
        EuroApplication app = (EuroApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        presenter.setView(this);
    }

    private void initializeAdapter() {
        adapter = new TeamsAdapter(presenter);
    }

    private void initializeRecyclerView() {
        binding.contentTeams.listTeams.setLayoutManager(new LinearLayoutManager(this));
        binding.contentTeams.listTeams.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.contentTeams.listTeams.setHasFixedSize(true);
        binding.contentTeams.listTeams.setAdapter(adapter);
    }

    private void startActivityActionView(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
