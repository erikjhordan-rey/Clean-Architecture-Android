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
import android.support.v4.content.ContextCompat;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import com.example.jhordan.euro_cleanarchitecture.EuroApplication;
import com.example.jhordan.euro_cleanarchitecture.R;
import com.example.jhordan.euro_cleanarchitecture.view.base.view.BaseActivity;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamDetailPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.example.jhordan.euro_cleanarchitecture.view.widget.HeaderView;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class TeamDetailsActivity extends BaseActivity implements TeamDetailPresenter.View {

  private final static String TEAM_FLAG_KEY = "team_flag_key";
  @Inject TeamDetailPresenter presenter;

  @Bind(R.id.header_detail) HeaderView detailHeader;
  @Bind(R.id.image_detail_history) ImageView imageDetailHistory;
  @Bind(R.id.label_best_result) TextView labelBestResult;
  @Bind(R.id.label_coach) TextView labelCoach;
  @Bind(R.id.label_leading_scorer) TextView labelLeadingScorer;
  @Bind(R.id.label_stadium) TextView labelStadium;
  @Bind(R.id.label_description_1) TextView labelDescription1;
  @Bind(R.id.label_matches_played) TextView labelMatchesPlayed;
  @Bind(R.id.label_overall) TextView labelOverall;
  @Bind(R.id.label_final_tournament) TextView labelFinalTournament;
  @Bind(R.id.image_detail_profile) ImageView imageDetailProfile;
  @Bind(R.id.label_description_2) TextView labelDescription2;
  @Bind(R.id.label_description_3) TextView labelDescription3;

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

  @Override public void showTeam(TeamViewModel teamViewModel) {

    if (getToolbar() != null) {
      getToolbar().setTitle(teamViewModel.getName());
    }
    detailHeader.initializeHeader(teamViewModel.getDisclaimer(), teamViewModel.getNickName());
    getImage(teamViewModel.getPictureOfDetail(), imageDetailHistory);
    labelBestResult.setText(teamViewModel.getBestResult());
    labelCoach.setText(teamViewModel.getCoach());
    labelLeadingScorer.setText(teamViewModel.getLeadingScorer());
    labelStadium.setText(teamViewModel.getStadium());
    labelDescription1.setText(teamViewModel.getDescriptionPart1());
    labelMatchesPlayed.setText(teamViewModel.getMatchesPlayed());
    labelOverall.setText(teamViewModel.getOverall());
    labelFinalTournament.setText(teamViewModel.getFinalTournament());
    getImage(teamViewModel.getPictureOfProfile(), imageDetailProfile);
    labelDescription2.setText(teamViewModel.getDescriptionPart2());
    labelDescription3.setText(teamViewModel.getDescriptionPart3());
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
    // I´m thinking...
  }

  @Override public void hideLoading() {
    // I´m thinking...
  }
}
