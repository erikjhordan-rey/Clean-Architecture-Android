package com.example.jhordan.euro_cleanarchitecture.rx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.AssertionFailedError;
import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

/*
 * Copyright (C) 2015 Ribot Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class RxAssertions {

    public static <T> ObservableAssertions<T> subscribeAssertingThat(Observable<T> observable) {
        return new ObservableAssertions<>(observable);
    }

    public static class ObservableAssertions<T> {

        private List<T> mResult;
        private Throwable mError;
        private boolean mCompleted;

        public ObservableAssertions(Observable<T> observable) {
            mCompleted = false;
            mResult = new ArrayList<>();
            observable.subscribeOn(Schedulers.immediate())
                    .subscribe(new Observer<T>() {
                        @Override
                        public void onCompleted() {
                            mCompleted = true;
                        }

                        @Override
                        public void onError(Throwable error) {
                            mError = error;
                        }

                        @Override
                        public void onNext(T item) {
                            mResult.add(item);
                        }
                    });
        }

        public ObservableAssertions<T> completesSuccessfully() {
            if (!mCompleted || mError != null) {
                if (mError != null) mError.printStackTrace();
                throw new AssertionFailedError("Observable has not completed successfully - cause: "
                        + (mError != null ? mError : "onComplete not called"));
            }
            return this;
        }

        public ObservableAssertions<T> fails() {
            if (mError == null) {
                throw new AssertionFailedError("Observable has not failed");
            }
            return this;
        }

        public ObservableAssertions<T> failsWithError(Throwable throwable) {
            fails();
            if (!throwable.equals(mError)) {
                throw new AssertionFailedError("Observable has failed with a different error," +
                        " expected is " + throwable + " but thrown was " + mError);
            }
            return this;
        }

        public ObservableAssertions<T> hasSize(int numItemsExpected) {
            if (numItemsExpected != mResult.size()) {
                throw new AssertionFailedError("Observable has emitted " + mResult.size()
                        + " items but expected was " + numItemsExpected);
            }
            return this;
        }

        @SafeVarargs
        public final ObservableAssertions<T> emits(T... itemsExpected) {
            completesSuccessfully();
            assertEmittedEquals(itemsExpected);
            return this;
        }

        @SuppressWarnings("unchecked")
        public ObservableAssertions<T> emits(Collection<T> itemsExpected) {
            completesSuccessfully();
            assertEmittedEquals((T[]) itemsExpected.toArray());
            return this;
        }

        public ObservableAssertions<T> emitsNothing() {
            completesSuccessfully();
            if (mResult.size() > 0) {
                throw new AssertionFailedError("Observable has emitted " + mResult.size() + " items");
            }
            return this;
        }

        private void assertEmittedEquals(T[] itemsExpected) {
            hasSize(itemsExpected.length);
            for (int i = 0; i < itemsExpected.length; i++) {
                T expected = itemsExpected[i];
                T actual = mResult.get(i);
                if (!expected.equals(actual)) {
                    throw new AssertionFailedError("Emitted item in position " + i + " does not match," +
                            "  expected " + expected + " actual " + actual);
                }
            }
        }

    }
}