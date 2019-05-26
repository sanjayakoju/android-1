package com.example.sanjayakoju.myapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnRegister;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=(Button) findViewById(R.id.lLogin);
        btnRegister=(Button) findViewById(R.id.lRegister);

        username = (EditText) findViewById(R.id.lUsername);
        password = (EditText) findViewById(R.id.lPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {

            String un=username.getText().toString();
            String pswd=password.getText().toString();
            public void onClick(View v) {

//
            }
        });


    }
}
