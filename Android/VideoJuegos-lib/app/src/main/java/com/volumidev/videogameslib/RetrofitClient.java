package com.volumidev.videogameslib;

import androidx.annotation.NonNull;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;

/**
 * @author Diego
 */
public class RetrofitClient {
     private static final String BASE_URL = "https://www.giantbomb.com/api/";
     private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            // Configurar el interceptor de logging
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY); // Nivel de logging

            // Construir el cliente OkHttp con los interceptores
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor) // Añade el interceptor de logging
                    .addInterceptor(new Interceptor() { // Interceptor para añadir encabezados adicionales
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request originalRequest = chain.request();
                            Request requestWithHeaders = originalRequest.newBuilder()
                                    .header("User-Agent", "Java Retrofit Client") // Ajusta según lo requiera la API
                                    .build();
                            return chain.proceed(requestWithHeaders);
                        }
                    })
                    .build();

            // Construir Retrofit con el cliente OkHttp configurado
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client) // Asigna el cliente OkHttp configurado
                    .build();
        }
        return retrofit;
    }
}
