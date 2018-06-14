package com.example.aon_attapon.live500px.manager.http;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiService {

    @POST("list")
    Call<Object> loadPhotoList();
}
