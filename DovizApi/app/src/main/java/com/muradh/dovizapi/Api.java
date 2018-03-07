package com.muradh.dovizapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Murad on 03/03/2018.
 */

public interface Api {

    String Base_url="https://www.doviz.com/api/v1/currencies/all/";

    @GET("latest")
    Call<List<Doviz>> getDoviz();

}
