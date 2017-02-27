package com.example.jorge.guatapeturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
}
