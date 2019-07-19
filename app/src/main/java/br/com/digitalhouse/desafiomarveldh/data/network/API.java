package br.com.digitalhouse.desafiomarveldh.data.network;

import br.com.digitalhouse.desafiomarveldh.model.Result;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("comics?")
    Single<Result> getComics(@Query("format") String format,
                             @Query("formatType") String formatType,
                             @Query("noVariants") boolean noVariants,
                             @Query("orderBy") String orderBy,
                             @Query("limit") String limit,
                             @Query("ts") String ts,
                             @Query("hash") String hash,
                             @Query("apikey") String apikey);

}
