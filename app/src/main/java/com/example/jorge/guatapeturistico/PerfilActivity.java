package com.example.jorge.guatapeturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PerfilActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuperfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.mPrincipal:
                intent= new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.mLogOut:
                intent= new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

        }

        return true;

    }

}
