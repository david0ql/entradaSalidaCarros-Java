package com.nordikhat.uts.services.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/auth")
    Call<LoginResponse> login(@Body LoginClass login);
}
