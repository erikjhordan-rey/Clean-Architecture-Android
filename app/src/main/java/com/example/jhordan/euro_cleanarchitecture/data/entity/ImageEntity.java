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

  @SerializedName("img_flag") private String imageFlag;
  @SerializedName("img_profile") private String imageProfile;
  @SerializedName("img_header") private String imageHeader;
  @SerializedName("img_detail") private String imageDetail;

  public String getImageFlag() {
    return imageFlag;
  }

  public String getImageProfile() {
    return imageProfile;
  }

  public String getImageHeader() {
    return imageHeader;
  }

  public String getImageDetail() {
    return imageDetail;
  }

  //create setters for test

  public void setImageDetail(String imageDetail) {
    this.imageDetail = imageDetail;
  }

  public void setImageHeader(String imageHeader) {
    this.imageHeader = imageHeader;
  }

  public void setImageProfile(String imageProfile) {
    this.imageProfile = imageProfile;
  }

  public void setImageFlag(String imageFlag) {
    this.imageFlag = imageFlag;
  }
}
