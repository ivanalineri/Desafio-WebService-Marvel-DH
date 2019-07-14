package br.com.digitalhouse.desafiomarveldh.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.desafiomarveldh.data.database.DatabaseRoom;
import br.com.digitalhouse.desafiomarveldh.data.database.dao.ResultsDAO;
import br.com.digitalhouse.desafiomarveldh.model.Result;
import br.com.digitalhouse.desafiomarveldh.repository.MarvelRespository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.desafiomarveldh.util.AppUtil.isNetworkConnected;

public class MarvelViewModel extends AndroidViewModel {
    private MutableLiveData<List<Result>> resultLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MarvelRespository repository = new MarvelRespository();


    public MarvelViewModel(@NonNull Application application) {
        super(application);
    }




    private void getFromLocal() {

        // Adicionamos a chamada a um disposible para podermos eliminar o disposable da destruição do viewmodel
        disposable.add(
                repository.getLocalResults(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> {
                            // setar livedata para mostrar loading
                        })
                        .doAfterTerminate(() -> {
                            // setar livedata para esconmder loading
                        })
                        .subscribe(results -> {
                            resultLiveData.setValue(results);
                        }, throwable -> {
                            // setar livedata para mostrar error
                        })
        );

    }






    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

}
