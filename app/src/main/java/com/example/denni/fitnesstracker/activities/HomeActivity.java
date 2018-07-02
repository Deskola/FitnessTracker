package com.example.denni.fitnesstracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.denni.fitnesstracker.R;

public class HomeActivity extends AppCompatActivity {
    Button mSignin,SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    public void signUpbtn(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
    }

    public void signInbtn(View view) {
        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
    }
}
