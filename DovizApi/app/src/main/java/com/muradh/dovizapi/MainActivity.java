package com.muradh.dovizapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

       final Button button =findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final ListView listview=findViewById(R.id.listView);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.Base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);

                Call<List<Doviz>> call = api.getDoviz();
                call.enqueue(new Callback<List<Doviz>>() {
                  @Override
                    public void onResponse(Call<List<Doviz>> call, Response<List<Doviz>> response) {
                        List<Doviz> doviz=response.body();

                        String[] dovizName=new String[doviz.size()];
                        for (int i=0;i<doviz.size();i++){
                            dovizName[i]=""+doviz.get(i).getCurrency();
                            dovizName[i]+=" <= "+doviz.get(i).getCode();
                            dovizName[i]+= " - "+doviz.get(i).getFull_name();
                            dovizName[i]+= " => Satish: "+doviz.get(i).getSelling();
                            dovizName[i]+= " => Alish:  "+doviz.get(i).getBuying();

                        }

                        listview.setAdapter(new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_expandable_list_item_1,
                                dovizName
                        ));

                    }

                    @Override
                    public void onFailure(Call<List<Doviz>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });







    }
}
