package com.example.owner.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private FavouriteFragment favouriteFragment;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mMainFrame = (FrameLayout)findViewById(R.id.main_frame);
    mMainNav = (BottomNavigationView)findViewById(R.id.main_nav);

    homeFragment = new HomeFragment();
    favouriteFragment = new FavouriteFragment();
    searchFragment = new SearchFragment();
        setFragment(homeFragment);

    mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case(R.id.navigation_home):
                    mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                    setFragment(homeFragment);
                    return true;
                case(R.id.navigation_favourites):
                    mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                    setFragment(favouriteFragment);
                    return true;
                case(R.id.navigation_search):
                    mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                    setFragment(searchFragment);
                    return true;
                default:
                    return false;

            }
        }
    });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

}