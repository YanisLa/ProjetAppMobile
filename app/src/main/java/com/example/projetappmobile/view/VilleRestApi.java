package com.example.projetappmobile.view;

import com.example.projetappmobile.model.RestVilleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface VilleRestApi {

    @Headers("x-api-key: VALEUR")
    @GET("17wtza")
    Call<RestVilleResponse> getListPokemon();
}
