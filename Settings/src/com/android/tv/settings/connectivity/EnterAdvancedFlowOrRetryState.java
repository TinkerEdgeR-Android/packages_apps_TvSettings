/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.android.tv.settings.connectivity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.android.tv.settings.connectivity.setup.AdvancedOptionsFlowInfo;
import com.android.tv.settings.connectivity.util.State;
import com.android.tv.settings.connectivity.util.StateMachine;

/**
 * State responsible for deciding enter advanced flow or retry.
 */
public class EnterAdvancedFlowOrRetryState implements State {
    private final FragmentActivity mActivity;
    private Fragment mFragment;

    public EnterAdvancedFlowOrRetryState(FragmentActivity activity) {
        mActivity = activity;
    }

    @Override
    public void processForward() {
        mFragment = null;
        StateMachine stateMachine = ViewModelProviders.of(mActivity).get(StateMachine.class);
        AdvancedOptionsFlowInfo advInfo = ViewModelProviders.of(mActivity)
                .get(AdvancedOptionsFlowInfo.class);
        if (advInfo.canStart()) {
            stateMachine.getListener().onComplete(StateMachine.ENTER_ADVANCED_FLOW);
        } else {
            stateMachine.getListener().onComplete(StateMachine.CONTINUE);
        }
    }

    @Override
    public void processBackward() {
        mFragment = null;
        StateMachine stateMachine = ViewModelProviders.of(mActivity).get(StateMachine.class);
        stateMachine.back();
    }

    @Override
    public Fragment getFragment() {
        return mFragment;
    }
}
