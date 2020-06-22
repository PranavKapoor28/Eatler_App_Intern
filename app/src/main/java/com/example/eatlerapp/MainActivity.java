package com.example.eatlerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Phone;
    EditText Email;
    EditText Pwd;
    Button Signup;
    TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Email=findViewById(R.id.EmailSign);
        Pwd=findViewById(R.id.PasswordSign);
        Name=findViewById(R.id.NameSign);
        Phone=findViewById(R.id.PhoneSign);
        Signup=findViewById(R.id.buttonSignup);
        login=findViewById(R.id.textViewSignin);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                String password = Pwd.getText().toString();
                String name = Name.getText().toString();
                String phone = Phone.getText().toString();

                if (name.length() == 0 || name.contains("(?=.*[0-9])+(?=.*[@#$%^&+=]) +(?=\\\\S+$)")) {
                    Name.setError("ENTER A VALID NAME");
                    return;
                }

                if (!Patterns.PHONE.matcher(phone).matches()) {
                    Phone.setError("Enter  Valid Phone Number");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Email.setError("ENTER A VALID EMAIL ADDRESS");
                    return;
                }

                if (password.length() == 0 ) {
                    Pwd.setError("ENTER A VALID PASSWORD");
                    return;
                }
                Intent signup=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(signup);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login =new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(login);
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