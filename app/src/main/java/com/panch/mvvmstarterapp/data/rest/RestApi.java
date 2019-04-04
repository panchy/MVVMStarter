package com.panch.mvvmstarterapp.data.rest;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

import java.util.List;

public interface RestApi {
    @GET("list")
    Single<Response<List<PhotoModel>>> getPhotosList();
}
