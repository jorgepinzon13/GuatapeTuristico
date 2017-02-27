package com.example.jorge.guatapeturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText eUsuario,ePassword;
    Button bInicio;
    TextView tReg;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario=(EditText)findViewById(R.id.eUsuario);
        ePassword=(EditText)findViewById(R.id.ePassword);
        bInicio=(Button) findViewById(R.id.bInicio);
        tReg=(TextView) findViewById(R.id.tReg);

        Bundle extras = getIntent().getExtras();



        bInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, RegistroActivity.class);
                /*intent.putExtra("username",eUsuario.getText().toString());
                intent.putExtra("password",ePassword.getText().toString());*/
                startActivityForResult(intent,1234);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){

            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");

        }

        if (requestCode==1234 && resultCode== RESULT_CANCELED){

            Toast.makeText(this,"Error en login",Toast.LENGTH_SHORT).show();
        }
    }
}
