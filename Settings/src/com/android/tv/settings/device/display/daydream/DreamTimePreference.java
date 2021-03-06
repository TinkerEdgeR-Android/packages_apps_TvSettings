/*
 * Copyright (C) 2016 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.tv.settings.device.display.daydream;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.v7.preference.ListPreference;
import android.text.TextUtils;
import android.util.AttributeSet;

@Keep
public class DreamTimePreference extends ListPreference {

    public DreamTimePreference(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public DreamTimePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DreamTimePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DreamTimePreference(Context context) {
        super(context);
    }

    @Override
    public CharSequence getSummary() {
        if (TextUtils.equals(getValue(), "-1")
            || TextUtils.equals(getValue(), "2147483647")) {
            return "Never";//getEntry();
        } else {
            return super.getSummary();
        }
    }
}
