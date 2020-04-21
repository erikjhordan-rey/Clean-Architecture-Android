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

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jhordan.euro_cleanarchitecture.databinding.TeamRowBinding;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import com.squareup.picasso.Picasso;

class TeamViewHolder extends RecyclerView.ViewHolder {

    private final TeamsPresenter teamsPresenter;
    private final TeamRowBinding teamRowBinding;

    TeamViewHolder(@NonNull TeamRowBinding binding, @NonNull TeamsPresenter teamsPresenter) {
        super(binding.getRoot());
        this.teamRowBinding = binding;
        this.teamsPresenter = teamsPresenter;
    }

    void render(TeamUi teamUi) {
        renderTeamHeaderImage(teamUi.getPictureOfHeader());
        renderTeamFlagImage(teamUi.getPictureOfFlag());
        renderTeamName(teamUi.getName());
        onItemClick(teamUi);
    }

    private void renderTeamHeaderImage(String urlHeaderImage) {
        getImage(urlHeaderImage, teamRowBinding.imageHeader);
    }

    private void renderTeamFlagImage(String urlFlagImage) {
        getImage(urlFlagImage, teamRowBinding.imageFlag);
    }

    private void renderTeamName(String name) {
        teamRowBinding.labelName.setText(name);
    }

    private void onItemClick(final TeamUi teamUi) {
        itemView.setOnClickListener(v -> teamsPresenter.onTeamClicked(teamUi));
    }

    private void getImage(String photo, ImageView photoImageView) {
        Picasso.get().load(photo).fit().centerCrop().into(photoImageView);
    }
}
