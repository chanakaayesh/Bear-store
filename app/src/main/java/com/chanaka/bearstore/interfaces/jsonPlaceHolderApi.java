package com.chanaka.bearstore.interfaces;

import com.chanaka.bearstore.Model.bear_main_model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface jsonPlaceHolderApi {
    @GET("v2/beers")
    Call<List<bear_main_model>> getmorebear(
            @Query("page") int page, @Query("per_page") int per_page
    );

    @GET("v2/beers")//search_bear
    Call<List<bear_main_model>> searh_bearName_(
            @Query("beer_name") String query
    );

}
