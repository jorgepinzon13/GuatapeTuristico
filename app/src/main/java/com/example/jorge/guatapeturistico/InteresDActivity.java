package com.example.jorge.guatapeturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class InteresDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username,email;
    Intent intent;
    EditText eUsuarioD,eEmailD;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);



        eUsuarioD = (EditText) hView.findViewById(R.id.eUsuarioD);
        eEmailD = (EditText) hView.findViewById(R.id.eEmailD);

        Bundle extras = getIntent().getExtras();
        eUsuarioD.setText(extras.getString("username"));
        eEmailD.setText(extras.getString("email"));

        username = extras.getString("username");
        email = extras.getString("email");

        navigationView.setNavigationItemSelectedListener(this);    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {

            intent = new Intent(InteresDActivity.this, MainDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_hotel) {

            intent = new Intent(InteresDActivity.this, HotelDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_bar) {

            intent = new Intent(InteresDActivity.this, BarDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_rest) {

            intent = new Intent(InteresDActivity.this, RestDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_logout) {

            intent = new Intent(InteresDActivity.this, LoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment = null;


            switch (position) {

                case 0:

                    InteresUnoFragment tab1  = new InteresUnoFragment();
                    return tab1;

                case 1:

                    InteresDosFragment tab2  = new InteresDosFragment();
                    return tab2;
                case 2:

                    InteresTresFragment tab3  = new InteresTresFragment();
                    return tab3;
            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.Sitio1);
                case 1:
                    return getResources().getString(R.string.Sitio2);
                case 2:
                    return getResources().getString(R.string.Sitio3);
            }
            return null;
        }
    }
}


