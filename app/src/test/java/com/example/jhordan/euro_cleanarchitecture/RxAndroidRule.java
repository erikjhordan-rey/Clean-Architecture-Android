package com.example.jhordan.euro_cleanarchitecture;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RxAndroidRule extends RXJavaRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                hookSchedulers();
                hookAndroidSchedulers();
                base.evaluate();
                restoreAndroidSchedulers();
                restoreSchedulers();
            }
        };
    }

    private void hookAndroidSchedulers() {
        RxAndroidPlugins.reset();
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.from(Runnable::run));
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    private void restoreAndroidSchedulers() {
        RxAndroidPlugins.reset();
    }
}
