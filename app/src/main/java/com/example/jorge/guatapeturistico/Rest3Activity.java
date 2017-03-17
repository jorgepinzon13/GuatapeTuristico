package com.example.jorge.guatapeturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class Rest3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username,email;
    Intent intent;
    EditText eUsuarioD,eEmailD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

        navigationView.setNavigationItemSelectedListener(this);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {

            intent = new Intent(Rest3Activity.this, MainDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();

        }
        else if (id == R.id.nav_hotel) {

            intent= new Intent(Rest3Activity.this, HotelDActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_interes) {

            intent= new Intent(Rest3Activity.this, InteresDActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_bar) {
            intent= new Intent(Rest3Activity.this, BarDActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.nav_rest) {

            intent= new Intent(Rest3Activity.this, RestDActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_logout) {

            intent= new Intent(Rest3Activity.this, LoginActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
