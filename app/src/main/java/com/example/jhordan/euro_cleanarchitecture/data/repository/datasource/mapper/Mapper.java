/*
 * Copyright (C) 2016 Karumi.
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

package com.example.jhordan.euro_cleanarchitecture.data.repository.datasource.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<T1, T2> {

  public abstract T2 map(T1 value);

  public abstract T1 reverseMap(T2 value);

  public List<T2> map(List<T1> values) {
    List<T2> returnValues = new ArrayList<>(values.size());
    for (T1 value : values) {
      returnValues.add(map(value));
    }
    return returnValues;
  }

  public List<T1> reverseMap(List<T2> values) {
    List<T1> returnValues = new ArrayList<>(values.size());
    for (T2 value : values) {
      returnValues.add(reverseMap(value));
    }
    return returnValues;
  }
}