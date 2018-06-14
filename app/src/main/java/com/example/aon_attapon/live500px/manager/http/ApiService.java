package com.example.aon_attapon.live500px.manager.http;

import com.example.aon_attapon.live500px.dao.PhotoItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiService {

    @POST("list")
    Call<PhotoItemCollectionDao> loadPhotoList();
}
