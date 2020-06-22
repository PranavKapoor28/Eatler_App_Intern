package com.example.eatlerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText Email;
    EditText Pwd;
    Button Login;
    TextView Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Email = findViewById(R.id.EmailLogin);
        Pwd = findViewById(R.id.PwdLogin);
        Login = findViewById(R.id.loginBtn);
        Signup = findViewById(R.id.SignupTxt);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Pwd.getText().toString();


                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Email.setError("ENTER A VALID EMAIL ADDRESS");
                    return;
                }

                if (password.length() == 0 ) {
                    Pwd.setError("ENTER A VALID PASSWORD");
                    return;
                }
                Intent login = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(login);

            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(SignUp);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}