package br.com.digitalhouse.desafiomarveldh.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.desafiomarveldh.data.database.DatabaseRoom;
import br.com.digitalhouse.desafiomarveldh.data.database.dao.ResultsDAO;
import br.com.digitalhouse.desafiomarveldh.data.network.RetrofitService;
import br.com.digitalhouse.desafiomarveldh.model.Result;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class MarvelRespository {

    public Flowable<List<Result>> getLocalResults(Context context){
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDAO resultsDao = room.resultsDAO();
        return resultsDao.getAll();
    }

    public void insertItems(Context context, List<Result> items) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDAO resultsDao = room.resultsDAO();
        resultsDao.insert(items);
    }

    public Observable<Result> searchItems(String item, int pagina, int limite) {
        return RetrofitService.getApiService().comicsItem(item, pagina, limite);
    }
}
