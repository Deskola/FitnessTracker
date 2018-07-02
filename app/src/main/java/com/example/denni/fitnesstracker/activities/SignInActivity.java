package com.example.denni.fitnesstracker.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.denni.fitnesstracker.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {
    private Button btnLogin;
    private TextView txtToRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in2);

        btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnLogin){
                    loginUser();
                }

            }
        });
        txtToRegister = findViewById(R.id.textViewRegister);
        txtToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });



    }
    public void loginUser() {
        startActivity(new Intent(SignInActivity.this, DashboardActivity.class));
    }

}
