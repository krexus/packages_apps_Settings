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
    private static final String KEY_KREXUS_MAINTAINER = "krexus_about_maintainer";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.krexus_about);
	getActivity().getActionBar().setTitle(R.string.krexus_about_title);

        final PreferenceScreen krexusAboutScreen = (PreferenceScreen)
                findPreference(SCREEN_KREXUS_ABOUT);
        final PreferenceGroup krexusMaintainerCategory = (PreferenceGroup)
                findPreference(CATEGORY_KREXUS_MAINTAINER);
        final Preference krexusMaintainerPref = (Preference)
                findPreference(KEY_KREXUS_MAINTAINER);

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
