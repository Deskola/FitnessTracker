package com.example.denni.fitnesstracker.apis;

import javax.xml.transform.Result;
import com.example.denni.fitnesstracker.models.*;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {
    @FormUrlEncoded
    @POST("register")
    Call<Result> createUser(
            @Field("full_name") String full_name,
            @Field("email") String email,
            @Field("gender") String gender,
            @Field("username") String username,
            @Field("password") String password

    );
}
