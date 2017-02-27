package com.example.jorge.guatapeturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {



    EditText eUsuario2,ePassword2, eRepass,eEmail;
    Button bReg,bCan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eUsuario2=(EditText)findViewById(R.id.eUsuario2);
        ePassword2=(EditText)findViewById(R.id.ePassword2);
        eRepass=(EditText)findViewById(R.id.eReppass);
        eEmail=(EditText)findViewById(R.id.eEmail);
        bReg=(Button) findViewById(R.id.bReg);
        bCan=(Button) findViewById(R.id.bCan);

        Bundle extras= getIntent().getExtras();
        Toast.makeText(this.)

        bCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RegistroActivity.this, LoginActivity.class);
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.putExtra("username",eUsuario2.getText().toString());
                intent.putExtra("password",ePassword2.getText().toString());
                intent.putExtra("email",eEmail.getText().toString());
                setResult(RESULT_OK,intent);
                finish();

            }
        });

    }
}
