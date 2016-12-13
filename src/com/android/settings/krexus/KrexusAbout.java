/*
 * Copyright (C) 2016 Krexus
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

package com.android.settings.krexus;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;

import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.MetricsProto.MetricsEvent;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class KrexusAbout extends SettingsPreferenceFragment {

    private static final String SCREEN_KREXUS_ABOUT = "screen_krexus_about";
    private static final String CATEGORY_KREXUS_MAINTAINER = "category_krexus_about_maintainer";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.krexus_about);
	getActivity().getActionBar().setTitle(R.string.krexus_about_title);

        final PreferenceScreen krexusAboutScreen = (PreferenceScreen)
                findPreference(SCREEN_KREXUS_ABOUT);
        final PreferenceGroup krexusMaintainerCategory = (PreferenceGroup)
                findPreference(CATEGORY_KREXUS_MAINTAINER);

        final String maintainerTitle = getString(R.string.krexus_about_maintainer_title);

        if (TextUtils.isEmpty(maintainerTitle)) {
            krexusAboutScreen.removePreference(krexusMaintainerCategory);
        }
    }

    @Override
    protected int getMetricsCategory() {
        return MetricsEvent.APPLICATION;
    }
}
