package com.android.settings.krexus;

import android.os.Bundle;

import com.android.internal.logging.MetricsLogger;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class SystemUISettings extends SettingsPreferenceFragment {

    @Override
    protected int getMetricsCategory() {
        return MetricsLogger.TUNER;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.krexus_system_ui_settings);
    }
}
