package com.muradh.retrofitapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview=findViewById(R.id.ListView);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Api.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Api api = retrofit.create(Api.class);

    Call<List<Hero>> call = api.getHeroes();
    call.enqueue(new Callback<List<Hero>>() {
        @Override
        public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
            List<Hero> heroes=response.body();

            String[] heroName=new String[heroes.size()];
            for (int i=0;i<heroes.size();i++){
                heroName[i]=heroes.get(i).getName();
                heroName[i]+= " - "+heroes.get(i).getRealname();
                heroName[i]+= " => "+heroes.get(i).getTeam();
                heroName[i]+= " => "+heroes.get(i).getFirstappearance();
                heroName[i]+= " => "+heroes.get(i).getCreatedby();
                heroName[i]+= " <= "+heroes.get(i).getPublisher();
               // heroName[i]+= " => "+heroes.get(i).getImageurl();
               // heroName[i]=heroes.get(i).getBio();
            }

            listview.setAdapter(new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_expandable_list_item_1,
                    heroName
            ));
           /* Write console log
            for (Hero h: heroes){
                Log.d("name",h.getName());
                Log.d("realname",h.getRealname());
                Log.d("team",h.getTeam());
                Log.d("firstappearance",h.getFirstappearance());
                Log.d("createdby",h.getCreatedby());
                Log.d("publisher",h.getPublisher());
                Log.d("imageurl",h.getImageurl());
                Log.d("bio",h.getBio());
            }*/
        }

        @Override
        public void onFailure(Call<List<Hero>> call, Throwable t) {
            Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
        }
    });

    }
}
