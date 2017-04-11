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

package com.example.jhordan.euro_cleanarchitecture.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.jhordan.euro_cleanarchitecture.R;

public class HeaderView extends LinearLayout {

  @BindView(R.id.txt_header_title) TextView titleLabel;
  @BindView(R.id.txt_header_subtitle) TextView subTitleLabel;

  public HeaderView(Context context) {
    super(context);
  }

  public HeaderView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    View view = LayoutInflater.from(getContext()).inflate(R.layout.header_detail, this, true);
    ButterKnife.bind(view);
  }

  public void initializeHeader(String disclaimer, String nickName) {
    titleLabel.setText(disclaimer);
    subTitleLabel.setText(nickName);
  }
}
