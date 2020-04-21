package com.example.jhordan.euro_cleanarchitecture;

import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RXJavaRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                hookSchedulers();
                base.evaluate();
                restoreSchedulers();
            }
        };
    }

    protected void hookSchedulers() {
        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setComputationSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setSingleSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    protected void restoreSchedulers() {
        RxJavaPlugins.reset();
    }
}
