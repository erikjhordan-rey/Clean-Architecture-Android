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

package com.example.jhordan.euro_cleanarchitecture.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

abstract class UseCase<T> {

  private final CompositeDisposable compositeDisposable;
  private final Scheduler executorThread;
  private final Scheduler uiThread;

  UseCase(Scheduler executorThread, Scheduler uiThread) {
    this.executorThread = executorThread;
    this.uiThread = uiThread;
    compositeDisposable = new CompositeDisposable();
  }

  public void execute(DisposableObserver<T> disposableObserver) {

    if (disposableObserver == null) {
      throw new IllegalArgumentException("disposableObserver must not be null");
    }

    final Observable<T> observable =
        this.createObservableUseCase().subscribeOn(executorThread).observeOn(uiThread);

    DisposableObserver observer = observable.subscribeWith(disposableObserver);
    compositeDisposable.add(observer);
  }

  public void dispose() {
    if (!compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
  }

  protected abstract Observable<T> createObservableUseCase();
}
