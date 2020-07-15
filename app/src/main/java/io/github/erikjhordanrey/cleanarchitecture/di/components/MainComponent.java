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

package io.github.erikjhordanrey.cleanarchitecture.di.components;

import android.content.Context;
import io.github.erikjhordanrey.cleanarchitecture.di.modules.MainModule;
import io.github.erikjhordanrey.cleanarchitecture.view.activity.TeamDetailActivity;
import io.github.erikjhordanrey.cleanarchitecture.view.activity.TeamsActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = MainModule.class) public interface MainComponent {

  void inject(TeamsActivity activity);

  void inject(TeamDetailActivity activity);

  Context context();
}
