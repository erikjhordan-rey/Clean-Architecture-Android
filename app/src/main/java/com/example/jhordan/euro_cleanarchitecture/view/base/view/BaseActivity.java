package com.example.jhordan.euro_cleanarchitecture.view.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.ButterKnife;
import com.example.jhordan.euro_cleanarchitecture.R;

/**
 * <p>
 * BaseActivity contains some modifications to the native AppCompatActivity.
 * Mainly, it use ButterKnife for view binding and it automatically check if
 * toolbar exists.
 * </p>
 */
public abstract class BaseActivity extends AppCompatActivity {

  private Toolbar mToolbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    setupToolbar();
    bindViews();
    initView();
  }

  /**
   * Use this method to initialize view components. This method is called after {@link
   * BaseActivity#bindViews()}
   */
  public void initView() {
  }

  /**
   * Its common use a toolbar within activity, if it exists in the
   * layout this will be configured
   */
  public void setupToolbar() {
    mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
    if (mToolbar != null) {
      setSupportActionBar(mToolbar);
    }
  }

  /**
   * Every object annotated with {@link butterknife.Bind} its gonna injected trough butterknife
   */
  private void bindViews() {
    ButterKnife.bind(this);
  }

  @Nullable public Toolbar getToolbar() {
    return mToolbar;
  }

  /**
   * @return The layout id that's gonna be the activity view.
   */
  protected abstract int getLayoutId();
}