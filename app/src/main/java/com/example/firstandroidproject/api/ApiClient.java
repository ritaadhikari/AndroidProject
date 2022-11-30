package com.example.firstandroidproject.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
//        retrofit ko instance yekchoti matrra call garos vanera
        if(retrofit== null){
//            logcat ko lagi instance create gareko
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//            it shows body ko valuse matra ligxa cause head ma xuttai body ma xutttai values haru hunxa
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//            builder pattren follow gareko
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .cache(null)
                    .build();

            retrofit = new Retrofit.Builder()
//                    base ligni main base which doesnot change
                    .baseUrl(Api.BASE_URL)

                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }
        else{
            return retrofit;
        }
    }

}
