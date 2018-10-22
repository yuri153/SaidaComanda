package br.com.pdv7.saidacomanda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.pdv7.saidacomanda.interfaces.InterfaceRetrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig  {

    public InterfaceRetrofit Service;

    public RetrofitConfig() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.77.108:7777/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Service = retrofit.create(InterfaceRetrofit.class);
    }
}
