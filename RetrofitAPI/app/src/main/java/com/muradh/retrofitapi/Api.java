package com.muradh.retrofitapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Murad on 03/02/2018.
 */

public interface Api {

    String base_url="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
