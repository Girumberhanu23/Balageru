package com.example.balageru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private TextView signup;
    private TextView back;
    private TextView info;
    private TextView forgot_password;
    private EditText phone;
    private EditText pwd;
    private Button btn_login;
    private Button btn_google;

    public static final String SHARER_PREFS="sharedPrefs";
    public static final String TEXT="text";
    //public static final String FULL_NAME="text";
    public static final String USERNAME="text";
    public static final String PASSWORD="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        back=findViewById(R.id.back);
        info=findViewById(R.id.info);
        forgot_password=findViewById(R.id.forgot_password);
        phone=findViewById(R.id.phone);
        pwd=findViewById(R.id.pwd);
        btn_login=findViewById(R.id.btn_login);
        btn_google=findViewById(R.id.btn_google);
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this, "This is text", Toast.LENGTH_SHORT).show();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences(SHARER_PREFS,MODE_PRIVATE);
                String s=sharedPreferences.getString(USERNAME, "");
                String s2=sharedPreferences.getString(PASSWORD,"");


                if (s.trim().equalsIgnoreCase(phone.getText().toString().trim()) && s2.equals(pwd.getText().toString())) {
                    Intent intent=new Intent(login.this, MainActivity.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(login.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Go_back=new Intent(login.this, MainActivity.class);
                startActivity(Go_back);
            }
        });
    }
}