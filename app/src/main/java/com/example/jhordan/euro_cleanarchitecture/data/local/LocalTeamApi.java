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

package com.example.jhordan.euro_cleanarchitecture.data.local;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LocalTeamApi {

    private final Context context;

    public LocalTeamApi(@NonNull Context context) {
        this.context = context;
    }

    public String readEuroDataJson() {
        final String EURO_DATA_FILE = "euro_data.json";
        String str = "";
        try {
            StringBuilder builder = new StringBuilder();
            InputStream json = context.getAssets().open(EURO_DATA_FILE);
            BufferedReader in = new BufferedReader(new InputStreamReader(json));

            while ((str = in.readLine()) != null) {
                builder.append(str);
            }
            in.close();
            str = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
