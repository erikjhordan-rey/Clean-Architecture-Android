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

package com.example.jhordan.euro_cleanarchitecture.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.jhordan.euro_cleanarchitecture.R;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

public class TeamViewHolder extends RecyclerView.ViewHolder {

  private final TeamsPresenter teamsPresenter;
  @Bind(R.id.image_header) ImageView headerImage;
  @Bind(R.id.image_flag) CircleImageView flagImage;
  @Bind(R.id.label_name) TextView nameLabel;

  public TeamViewHolder(@NonNull View itemView, @NonNull TeamsPresenter teamsPresenter) {
    super(itemView);
    this.teamsPresenter = teamsPresenter;
    ButterKnife.bind(this, itemView);
  }

  public void render(TeamViewModel team) {
    onItemClick(team);
    System.out.println(team.getPictureOfHeader());
    renderTeamHeaderImage(team.getPictureOfHeader());
    renderTeamFlagImage(team.getPictureOfFlag());
    renderTeamName(team.getName());
  }

  private void onItemClick(final TeamViewModel teamViewModel) {
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        teamsPresenter.onTeamClicked(teamViewModel);
      }
    });
  }

  private void renderTeamHeaderImage(String urlHeaderImage) {
    getImage(urlHeaderImage, headerImage);
  }

  private void renderTeamFlagImage(String urlFlagImage) {
    getImage(urlFlagImage, flagImage);
  }

  private void renderTeamName(String name) {
    nameLabel.setText(name);
  }

  private void getImage(String photo, ImageView photoImageView) {
    Picasso.with(getContext()).load(photo).fit().centerCrop().into(photoImageView);
  }

  private Context getContext() {
    return itemView.getContext();
  }
}
