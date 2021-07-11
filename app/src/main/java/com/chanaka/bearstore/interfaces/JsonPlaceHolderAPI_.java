package com.chanaka.bearstore.interfaces;

import com.chanaka.bearstore.Model.bear_main_model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI_ {
    @GET("v2/beers/1")
    Call<bear_main_model> getUsers_();
}
