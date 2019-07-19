package br.com.digitalhouse.desafiomarveldh.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.desafiomarveldh.data.database.DatabaseRoom;
import br.com.digitalhouse.desafiomarveldh.data.database.dao.ResultsDAO;
import br.com.digitalhouse.desafiomarveldh.data.network.RetrofitService;
import br.com.digitalhouse.desafiomarveldh.model.Result;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

import static br.com.digitalhouse.desafiomarveldh.data.network.RetrofitService.PRIVATE_KEY;
import static br.com.digitalhouse.desafiomarveldh.data.network.RetrofitService.PUBLIC_KEY;
import static br.com.digitalhouse.desafiomarveldh.data.network.RetrofitService.getApiService;
import static br.com.digitalhouse.desafiomarveldh.util.AppUtil.md5;

public class MarvelRespository {

    public Flowable<List<Result>> getLocalResults(Context context) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDAO resultsDao = room.resultsDAO();
        return resultsDao.getAll();
    }

    public void insertItems(Context context, List<Result> items) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDAO resultsDao = room.resultsDAO();
        resultsDao.insert(items);
    }


    public Single<Result> getComicsApi() {
        String ts = Long.toString(System.currentTimeMillis() / 1000);
        String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

        Single<Result> comicsResponseSingle = getApiService()
                .getComics("magazine"
                        , "comic"
                        , true
                        , "focDate"
                        , "50"
                        , ts
                        , hash
                        , PUBLIC_KEY);
        return comicsResponseSingle;

    }
}