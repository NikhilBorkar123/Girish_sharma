package com.example.abc.girishsharma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,BhumiPujan.OnFragmentInteractionListener,VrukshaRopan.OnFragmentInteractionListener,SamuhikVivah.OnFragmentInteractionListener,BetiBachao.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleMarginEnd(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        }else if (id == R.id.nav_gallery) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new GalleryFragment()).commit();
        } else if (id == R.id.nav_social) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SocialFragment()).commit();
        } else if (id == R.id.nav_appointment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AppointmentFragment()).commit();
        } else if (id == R.id.nav_add_volunteer) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new VolunteerFragment()).commit();
        } else if (id == R.id.nav_share_details) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ShareDetailsFragment()).commit();
        } else if (id == R.id.nav_notifications) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NotificationFragment()).commit();
        }else if (id == R.id.nav_myprofile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MyprofileFragment()).commit();
        }else if (id == R.id.nav_my_journey) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MyJourneyFragment()).commit();
        }else if (id == R.id.nav_my_vision) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MyVisionFragment()).commit();
        }else if (id == R.id.nav_issues) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new IssuesFragment()).commit();
        }else if (id == R.id.nav_utilities) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UtilitiesFragment()).commit();
        }else if (id == R.id.nav_events) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new EventFragment()).commit();
        }else if (id == R.id.nav_logout) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LogoutFragment()).commit();
        }else if (id == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SettingsFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
