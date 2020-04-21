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
import android.os.Build;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.jhordan.euro_cleanarchitecture.EuroApplication;
import com.example.jhordan.euro_cleanarchitecture.R;
import com.example.jhordan.euro_cleanarchitecture.core.view.BaseActivity;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamDetailPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;
import com.example.jhordan.euro_cleanarchitecture.view.widget.HeaderView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;

public class TeamDetailsActivity extends BaseActivity implements TeamDetailPresenter.View {

  private final static String TEAM_FLAG_KEY = "team_flag_key";
  @Inject TeamDetailPresenter presenter;

  @BindView(R.id.header_detail) HeaderView detailHeader;
  @BindView(R.id.image_detail_history) ImageView imageDetailHistory;
  @BindView(R.id.label_best_result) TextView labelBestResult;
  @BindView(R.id.label_coach) TextView labelCoach;
  @BindView(R.id.label_leading_scorer) TextView labelLeadingScorer;
  @BindView(R.id.label_stadium) TextView labelStadium;
  @BindView(R.id.label_description_1) TextView labelDescription1;
  @BindView(R.id.label_matches_played) TextView labelMatchesPlayed;
  @BindView(R.id.label_overall) TextView labelOverall;
  @BindView(R.id.label_final_tournament) TextView labelFinalTournament;
  @BindView(R.id.image_detail_profile) ImageView imageDetailProfile;
  @BindView(R.id.label_description_2) TextView labelDescription2;
  @BindView(R.id.label_description_3) TextView labelDescription3;

  public static void open(Context context, String superHeroName) {
    Intent intent = new Intent(context, TeamDetailsActivity.class);
    intent.putExtra(TEAM_FLAG_KEY, superHeroName);
    context.startActivity(intent);
  }

  @Override public void initView() {
    super.initView();
    initializeToolbar();
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

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  private String getTeamFlagKey() {
    return getIntent().getExtras().getString(TEAM_FLAG_KEY);
  }

  @Override public void showTeam(TeamUi teamUi) {

    if (getToolbar() != null) {
      getToolbar().setTitle(teamUi.getName());
    }
    detailHeader.initializeHeader(teamUi.getDisclaimer(), teamUi.getNickName());
    getImage(teamUi.getPictureOfDetail(), imageDetailHistory);
    labelBestResult.setText(teamUi.getBestResult());
    labelCoach.setText(teamUi.getCoach());
    labelLeadingScorer.setText(teamUi.getLeadingScorer());
    labelStadium.setText(teamUi.getStadium());
    labelDescription1.setText(teamUi.getDescriptionPart1());
    labelMatchesPlayed.setText(teamUi.getMatchesPlayed());
    labelOverall.setText(teamUi.getOverall());
    labelFinalTournament.setText(teamUi.getFinalTournament());
    getImage(teamUi.getPictureOfProfile(), imageDetailProfile);
    labelDescription2.setText(teamUi.getDescriptionPart2());
    labelDescription3.setText(teamUi.getDescriptionPart3());
  }

  private void getImage(String photo, ImageView photoImageView) {
    Picasso.with(photoImageView.getContext()).load(photo).fit().centerCrop().into(photoImageView);
  }

  private void initializeToolbar() {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(
          ContextCompat.getColor(TeamDetailsActivity.this, R.color.colorPrimaryDark));
    }

    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }

  @Override public void showLoading() {
    // I did a bad design.
  }

  @Override public void hideLoading() {
    // I did a bad design.
  }
}
