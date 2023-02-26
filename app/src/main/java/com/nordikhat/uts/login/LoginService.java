package com.nordikhat.uts.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/auth")
    Call<LoginClass> login(@Body LoginClass login);
}
