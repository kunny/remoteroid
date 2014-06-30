package com.androidhuman.remoteroid.ui.activity;

import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androidhuman.remoteroid.R;
import com.androidhuman.remoteroid.ui.fragment.NotificationFragment;


public class MainActivity extends ActionBarActivity {

    DrawerLayout dlDrawer;
    ActionBarDrawerToggle dtToggle;

    int lastFragmentId = -1;
    static final String KEY_FRAGMENT_ID = "fragment_id";
    static final int FRAGMENT_NOTIFICATION = 10;
    static final int FRAGMENT_ACCOUNT = 20;

    // Fragments
    NotificationFragment fragNotification;
    //AccountFragment fragAccount;

    private void selectFragment(int fragmentId){
        Fragment fragment;

        switch(fragmentId){
            case FRAGMENT_NOTIFICATION:
                fragment = fragNotification;
                lastFragmentId = FRAGMENT_NOTIFICATION;
                break;
            case FRAGMENT_ACCOUNT:
                fragment = null; // TODO Assign AccountFragment here
                lastFragmentId = FRAGMENT_ACCOUNT;
                break;
            default:
                throw new IllegalArgumentException("Invalid fragment id : "+fragmentId);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_activity_main_container, fragment)
                .commit();
    }

    private void initFragments(){
        if(fragNotification==null){
            fragNotification = new NotificationFragment();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragments();

        if(savedInstanceState!=null){
            // Restore fragment state on here
            lastFragmentId = savedInstanceState.getInt(KEY_FRAGMENT_ID);
            selectFragment(lastFragmentId);
        }else{
            selectFragment(FRAGMENT_NOTIFICATION);
        }

        dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main);
        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.drawable.ic_drawer,
                R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        dtToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_FRAGMENT_ID, lastFragmentId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(dtToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
