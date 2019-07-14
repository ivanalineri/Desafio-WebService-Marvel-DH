package br.com.digitalhouse.desafiomarveldh.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.desafiomarveldh.model.Result;
import io.reactivex.Flowable;

@Dao
public interface ResultsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Result> results);

    @Update
    void update(Result result);

    @Delete
    void delete(Result result);

    @Query("Delete from result")
    void deleteAll();

    @Query("Select * from result limit 30")
    Flowable<List<Result>> getAll();

}
