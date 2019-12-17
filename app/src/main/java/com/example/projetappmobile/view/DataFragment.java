package com.example.projetappmobile.view;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetappmobile.MyAdapter;
import com.example.projetappmobile.R;
import com.example.projetappmobile.model.Ville;
import com.example.projetappmobile.model.RestVilleResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DataFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_data, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        VilleRestApi villeRestApi = retrofit.create(VilleRestApi.class);

        Call<RestVilleResponse> call = villeRestApi.getListPokemon();
        call.enqueue(new Callback<RestVilleResponse>() {
            @Override
            public void onResponse(Call<RestVilleResponse> call, Response<RestVilleResponse> response) {
                RestVilleResponse restVilleResponse = response.body();
                List<Ville> listVille = restVilleResponse.getResults();
                showList(listVille);

            }

            @Override
            public void onFailure(Call<RestVilleResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");


            }
        });


        return rootView;
    }

    public void showList(List<Ville> list){

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(list);
        recyclerView.setAdapter(mAdapter);
    }
}