package com.example.sanjayakoju.myapp1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btnLogin, btnRegister;
    EditText username,password,mobileNumber,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper=new DBHelper(this);
        btnLogin= (Button) findViewById(R.id.rLogin);
        btnRegister= (Button) findViewById(R.id.rRegister);
        username = (EditText) findViewById(R.id.rUsername);
        password =(EditText) findViewById(R.id.rPassword);
        mobileNumber =(EditText) findViewById(R.id.mobileNumber);
        email =(EditText) findViewById(R.id.email);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db=openHelper.getWritableDatabase();
                String un=username.getText().toString();
                String pswd=password.getText().toString();
                String mob=mobileNumber.getText().toString();
                String emai=email.getText().toString();
                insertData(un,pswd,mob,emai);
                Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_LONG).show();

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void insertData(String un,String pswd, String mob, String emai)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.Col_2,un);
        contentValues.put(DBHelper.Col_3,pswd);
        contentValues.put(DBHelper.Col_4,mob);
        contentValues.put(DBHelper.Col_5,emai);
        long id=db.insert(DBHelper.TABLE_NAME,null,contentValues);
    }
}
