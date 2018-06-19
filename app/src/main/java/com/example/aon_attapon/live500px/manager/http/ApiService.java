package com.example.aon_attapon.live500px.manager.http;

import com.example.aon_attapon.live500px.dao.PhotoItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("list")
    Call<PhotoItemCollectionDao> loadPhotoList();

    @POST("list/after/{id}")
    Call<PhotoItemCollectionDao> loadPhotoListAdterId(@Path("id") int id);
}
