package com.example.denni.fitnesstracker.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.denni.fitnesstracker.R;
import com.example.denni.fitnesstracker.fragments.DashboardFragment;
import com.example.denni.fitnesstracker.fragments.InstructorsFragment;
import com.example.denni.fitnesstracker.fragments.LocationFragment;
import com.example.denni.fitnesstracker.fragments.PastRecordFragment;
import com.example.denni.fitnesstracker.fragments.WorkoutFragment;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.language_english:
               //change language to English
            case R.id.language_chinese:
                //change language to Chinese
            case R.id.language_french:
                //change language to French
        }

        return super.onOptionsItemSelected(item);
    }
    private void displaySelectedScreen(int itemId)
    {

        //create Fragment obj
        Fragment fragment = null;

        switch (itemId)
        {
            case R.id.nav_home:
                fragment = new DashboardFragment();
                break;
            case R.id.nav_map:
                fragment = new LocationFragment();
                break;
            case R.id.nav_workout:
                fragment = new WorkoutFragment();
                break;
            case R.id.nav_pastworkout:
                fragment = new PastRecordFragment();
                break;
            case R.id.nav_instructors:
                fragment = new InstructorsFragment();
                break;
        }
        if (fragment != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainlayout, fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }

}
