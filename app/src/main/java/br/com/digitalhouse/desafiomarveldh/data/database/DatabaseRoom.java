package br.com.digitalhouse.desafiomarveldh.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.desafiomarveldh.data.database.dao.ResultsDAO;
import br.com.digitalhouse.desafiomarveldh.model.Result;

@Database(entities = {Result.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class) // Adicionamos os conversores
public abstract class DatabaseRoom extends RoomDatabase {

    public abstract ResultsDAO resultsDAO();

    private static volatile DatabaseRoom INSTANCE;

    public static DatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseRoom.class, "marvel_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
