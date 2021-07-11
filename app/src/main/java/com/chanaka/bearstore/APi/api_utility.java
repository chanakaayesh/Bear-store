package com.chanaka.bearstore.APi;

import com.chanaka.bearstore.interfaces.jsonPlaceHolderApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class api_utility {
    public  static  final  String BASE_URL ="https://api.punkapi.com/";
    public  static Retrofit retrofit = null;

    public  static jsonPlaceHolderApi getapiInterface() {
        if(retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(jsonPlaceHolderApi.class);
    }
}
