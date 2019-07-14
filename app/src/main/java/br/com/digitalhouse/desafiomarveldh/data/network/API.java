package br.com.digitalhouse.desafiomarveldh.data.network;

import br.com.digitalhouse.desafiomarveldh.model.Result;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/v1/public/comics")
    Observable<Result> comicsItem(@Query("q") String item,
                                  @Query("offset") int pagina,
                                  @Query("limit") int limite);
}
