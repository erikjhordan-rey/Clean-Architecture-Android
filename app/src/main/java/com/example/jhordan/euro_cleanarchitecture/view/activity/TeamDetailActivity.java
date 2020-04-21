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
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jhordan.euro_cleanarchitecture.EuroApplication;
import com.example.jhordan.euro_cleanarchitecture.databinding.ActivityTeamDetailBinding;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamDetailPresenter;
import com.squareup.picasso.Picasso;
import java.util.Objects;
import javax.inject.Inject;

public class TeamDetailActivity extends AppCompatActivity implements TeamDetailPresenter.View {

    private final static String TEAM_FLAG_KEY = "team_flag_key";

    @Inject
    TeamDetailPresenter presenter;

    private ActivityTeamDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeamDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializeToolbar();
        initializeDagger();
        initializePresenter();
    }

    private void initializeDagger() {
        EuroApplication euroApplication = (EuroApplication) getApplication();
        euroApplication.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        presenter.setView(this);
        final String flag = getTeamFlagKey();
        presenter.setTeamFlag(flag);
        presenter.initialize();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void showTeam(TeamUi teamUi) {
        binding.toolbar.setTitle(teamUi.getName());
        binding.headerDetail.initializeHeader(teamUi.getDisclaimer(), teamUi.getNickName());
        getImage(teamUi.getPictureOfDetail(), binding.imageDetailHistory);
        binding.labelBestResult.setText(teamUi.getBestResult());
        binding.labelCoach.setText(teamUi.getCoach());
        binding.labelLeadingScorer.setText(teamUi.getLeadingScorer());
        binding.labelStadium.setText(teamUi.getStadium());
        binding.labelDescription1.setText(teamUi.getDescriptionPart1());
        binding.labelMatchesPlayed.setText(teamUi.getMatchesPlayed());
        binding.labelOverall.setText(teamUi.getOverall());
        binding.labelFinalTournament.setText(teamUi.getFinalTournament());
        getImage(teamUi.getPictureOfProfile(), binding.imageDetailProfile);
        binding.labelDescription2.setText(teamUi.getDescriptionPart2());
        binding.labelDescription3.setText(teamUi.getDescriptionPart3());
    }

    private String getTeamFlagKey() {
        return Objects.requireNonNull(getIntent().getExtras()).getString(TEAM_FLAG_KEY);
    }

    private void getImage(String photo, ImageView photoImageView) {
        Picasso.with(photoImageView.getContext()).load(photo).fit().centerCrop().into(photoImageView);
    }

    private void initializeToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public static void open(Context context, String superHeroName) {
        Intent intent = new Intent(context, TeamDetailActivity.class);
        intent.putExtra(TEAM_FLAG_KEY, superHeroName);
        context.startActivity(intent);
    }
}
