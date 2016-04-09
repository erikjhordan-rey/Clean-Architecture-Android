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

package com.example.jhordan.euro_cleanarchitecture.data.entity;

import com.google.gson.annotations.SerializedName;

public class ImageEntity {

  @SerializedName("img_flag") private String imgFlag;
  @SerializedName("img_profile") private String imgProfile;
  @SerializedName("img_header") private String imgHeader;
  @SerializedName("img_detail") private String imgDetail;

  public String getImgFlag() {
    return imgFlag;
  }

  public String getImgProfile() {
    return imgProfile;
  }

  public String getImgHeader() {
    return imgHeader;
  }

  public String getImgDetail() {
    return imgDetail;
  }

}
