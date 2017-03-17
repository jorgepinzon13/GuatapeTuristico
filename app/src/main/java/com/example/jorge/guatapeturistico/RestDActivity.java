package com.example.jorge.guatapeturistico;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username,email;
    EditText eUsuarioD,eEmailD;

    Intent intent;
    Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.rest1,17910,26866, "Pizzería De Luigi" ," Italiana, Pizza, Apto para vegetarianos, Opciones veganas "),
            new Lista_Entrada(R.drawable.rest2,1000, 20000, "Café La Viña","Café, Colombiana "),
            new Lista_Entrada(R.drawable.rest3,8955, 28851,"Thai Terrace"," Tailandesa, Asiática, Apto para vegetarianos, Opciones veganas ")
    };

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Adapter adapter = new Adapter(this,datos);

        lista = (ListView) findViewById(R.id.Lista);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch(position) {

                    case 0:
                        intent = new Intent(RestDActivity.this, Rest1Activity.class);
                        startActivity(intent);
                        intent.putExtra("username",username);
                        intent.putExtra("email",email);
                        finish();
                        break;

                    case 1:
                        intent = new Intent(RestDActivity.this, Rest2Activity.class);
                        startActivity(intent);
                        intent.putExtra("username",username);
                        intent.putExtra("email",email);
                        finish();
                        break;
                    case 2:
                        intent = new Intent(RestDActivity.this, Rest3Activity.class);
                        startActivity(intent);
                        intent.putExtra("username",username);
                        intent.putExtra("email",email);
                        finish();
                        break;
                    default:
                }




            }
        });


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

    class Adapter extends ArrayAdapter<Lista_Entrada> {


        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context,R.layout.listview_item,datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_item,null);

            TextView nombre = (TextView) item.findViewById(R.id.tInter);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDes1);
            descrip.setText(datos[position].getDescripcion());

            TextView precio1 = (TextView) item.findViewById(R.id.tPrec1);
            precio1.setText(String.valueOf(datos[position].getPrecio1()));

            TextView precio2 = (TextView) item.findViewById(R.id.tPrec2);
            precio2.setText(String.valueOf(datos[position].getPrecio2()));

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());


            return item;
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {

            intent = new Intent(RestDActivity.this, MainDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();

        }
        else if (id == R.id.nav_hotel) {

            intent= new Intent(RestDActivity.this, HotelDActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_interes) {

            intent= new Intent(RestDActivity.this, InteresDActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();

        }

        else if (id == R.id.nav_bar) {
            intent= new Intent(RestDActivity.this, BarDActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.nav_logout) {

            intent= new Intent(RestDActivity.this, LoginActivity.class);
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
