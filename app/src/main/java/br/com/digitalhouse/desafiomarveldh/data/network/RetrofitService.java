package br.com.digitalhouse.desafiomarveldh.data.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import br.com.digitalhouse.desafiomarveldh.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL ="https://gateway.marvel.com:443";

    private static Retrofit retrofit;

    private static Retrofit getRetrofit(){
        if (retrofit == null) {

            // configurações da conexão
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);

            // Se for Debug habilitamos os logs
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
                httpClient.addNetworkInterceptor(new StethoInterceptor());
            }

            // Inicializamos o retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    public static API getApiService() {
        return getRetrofit().create(API.class);
    }
}
