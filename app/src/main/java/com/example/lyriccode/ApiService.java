package com.example.lyriccode;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("login")
    Call<AuthResponse> login(@Body AuthRequest authRequest);

    @POST("signup")
    Call<AuthResponse> signup(@Body AuthRequest authRequest);
}
