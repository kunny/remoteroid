package com.androidhuman.remoteroid.ui.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidhuman.remoteroid.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class NotificationFragment extends PreferenceFragment {


    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.rd_notification_preference);
    }


}
