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

package com.example.jhordan.euro_cleanarchitecture.di.modules;

import android.content.Context;
import com.example.jhordan.euro_cleanarchitecture.EuroApplication;
import com.example.jhordan.euro_cleanarchitecture.data.repository.Repository;
import com.example.jhordan.euro_cleanarchitecture.data.repository.TeamsRepository;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class MainModule {

  private final EuroApplication euroApplication;

  public MainModule(EuroApplication euroApplication) {
    this.euroApplication = euroApplication;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return euroApplication;
  }

  @Provides @Singleton Repository provideRepository(TeamsRepository teamsRepository) {
    return teamsRepository;
  }

  @Provides @Named("executor_thread") Scheduler provideExecutorThread() {
    return Schedulers.io();
  }

  @Provides @Named("ui_thread") Scheduler provideUiThread() {
    return AndroidSchedulers.mainThread();
  }
}
