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

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jhordan.euro_cleanarchitecture.R;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.viewmodel.TeamViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private final TeamsPresenter presenter;
  private final List<TeamViewModel> teamList;

  public TeamsAdapter(@NonNull TeamsPresenter presenter) {
    this.presenter = presenter;
    teamList = new ArrayList<>();
  }

  @NonNull
  @Override public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_row, parent, false);
    return new TeamViewHolder(view, presenter);
  }

  @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    TeamViewHolder teamViewHolder = (TeamViewHolder) holder;
    TeamViewModel team = teamList.get(position);
    teamViewHolder.render(team);
  }

  @Override public int getItemCount() {
    return teamList.size();
  }

  public void addAll(Collection<TeamViewModel> collection) {
    teamList.addAll(collection);
  }
}
