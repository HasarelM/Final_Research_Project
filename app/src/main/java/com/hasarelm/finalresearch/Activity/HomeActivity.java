package com.hasarelm.finalresearch.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hasarelm.finalresearch.Fragment.AddFarmerFragment;
import com.hasarelm.finalresearch.Fragment.FarmerListFragment;
import com.hasarelm.finalresearch.Fragment.HomeFragment;
import com.hasarelm.finalresearch.Fragment.SettingFragment;
import com.hasarelm.finalresearch.R;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView mBtnBottomNavigation;
    private boolean mBackPressedToExitOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBtnBottomNavigation = findViewById(R.id.bottomNavigationView);
        mBtnBottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:
                            Fragment fragment = new HomeFragment();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.container, fragment);
                            fragmentTransaction.commit();
                            return true;
                        case R.id.add_farmer:
                            Fragment frament = new AddFarmerFragment();
                            FragmentManager fragmentManageer = getSupportFragmentManager();
                            FragmentTransaction fragmentTrsaction = fragmentManageer.beginTransaction();
                            fragmentTrsaction.replace(R.id.container, frament);
                            fragmentTrsaction.commit();
                            return true;
                        case R.id.farmer_list:
                            Fragment fragmeffnt = new FarmerListFragment();
                            FragmentManager fragmentManahhger = getSupportFragmentManager();
                            FragmentTransaction fragmentTrkkansaction = fragmentManahhger.beginTransaction();
                            fragmentTrkkansaction.replace(R.id.container, fragmeffnt);
                            fragmentTrkkansaction.commit();
                            return true;
                        case R.id.settings:
                            Fragment fragmsseffnt = new SettingFragment();
                            FragmentManager fragmentMallnahhger = getSupportFragmentManager();
                            FragmentTransaction fragmentTrkkllansaction = fragmentMallnahhger.beginTransaction();
                            fragmentTrkkllansaction.replace(R.id.container, fragmsseffnt);
                            fragmentTrkkllansaction.commit();
                            return true;
                    }
                    return false;
                }
            };
}