package com.example.denni.fitnesstracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.denni.fitnesstracker.R;
import com.example.denni.fitnesstracker.apis.ApiServices;
import com.example.denni.fitnesstracker.apis.ApiUrls;
import com.example.denni.fitnesstracker.models.User;


import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    private Button mRegisterUserBtn;
    private EditText txtFullName, txtEmail, txtUsername, txtPassword;
    private RadioGroup radioGender;
    private TextView txtToLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mRegisterUserBtn = findViewById(R.id.buttonRegister);

        txtFullName = findViewById(R.id.txtFullNameReg);
        txtEmail = findViewById(R.id.txtEmailReg);
        txtUsername = findViewById(R.id.txtUsernameReg);
        txtPassword = findViewById(R.id.txtPasswordReg);
        radioGender = findViewById(R.id.radioGender);

        txtToLogin = findViewById(R.id.textViewLogin);
        txtToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
        mRegisterUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mRegisterUserBtn){
                    userSignUp();
                }
            }
        });

    }
    private void userSignUp()
    {
        //capture user values
        final RadioButton radiognd = findViewById(radioGender.getCheckedRadioButtonId());
        String name = txtFullName.getText().toString();
        String email = txtEmail.getText().toString();
        String username = txtUsername.getText().toString();
        String gender = radiognd.getText().toString();
        String password = txtPassword.getText().toString();


        //crete retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrls.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //defining retrofit api services that communicates with ApiServices class
        ApiServices services = retrofit.create(ApiServices.class);

        //defining the user values as we need to pass it with the call
        User user = new User(name, email, gender, username, password);

        //define the call
        Call<Result> call = services.createUser(
                user.getName(),
                user.getEmail(),
                user.getGender(),
                user.getUsername(),
                user.getPassword()

        );

        //call api
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Toast.makeText(SignUpActivity.this, (CharSequence) response.body(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }


}
