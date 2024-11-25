package com.volumidev.videogameslib;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
     private static final String BASE_URL = "https://www.giantbomb.com/api/";
     private static Retrofit retrofit = null;

     public static Retrofit getClient(){
         if(retrofit == null){
             //configuramos el interceptor de Logs
             HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
             interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

             OkHttpClient client = new OkHttpClient.Builder()
                     .addInterceptor(interceptor)
                     .build();

             retrofit = new Retrofit.Builder()
                     .baseUrl(BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create())
                     .client(client)
                     .build();

         }
         return retrofit;
     }
}
