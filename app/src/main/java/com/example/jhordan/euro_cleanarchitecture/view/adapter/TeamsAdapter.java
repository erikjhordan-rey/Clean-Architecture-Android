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

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jhordan.euro_cleanarchitecture.databinding.TeamRowBinding;
import com.example.jhordan.euro_cleanarchitecture.view.presenter.TeamsPresenter;
import com.example.jhordan.euro_cleanarchitecture.view.model.TeamUi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final TeamsPresenter presenter;
    private final List<TeamUi> teamUiList;

    public TeamsAdapter(@NonNull TeamsPresenter presenter) {
        this.presenter = presenter;
        teamUiList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeamViewHolder(TeamRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final TeamViewHolder teamViewHolder = (TeamViewHolder) holder;
        teamViewHolder.render(teamUiList.get(position));
    }

    @Override
    public int getItemCount() {
        return teamUiList.size();
    }

    public void addAll(Collection<TeamUi> collection) {
        teamUiList.addAll(collection);
    }
}
