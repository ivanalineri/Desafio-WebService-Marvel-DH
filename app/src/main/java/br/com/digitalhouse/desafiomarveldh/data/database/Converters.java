package br.com.digitalhouse.desafiomarveldh.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.com.digitalhouse.desafiomarveldh.model.Characters;
import br.com.digitalhouse.desafiomarveldh.model.Creators;
import br.com.digitalhouse.desafiomarveldh.model.Data;
import br.com.digitalhouse.desafiomarveldh.model.Image;
import br.com.digitalhouse.desafiomarveldh.model.MarvelComics;
import br.com.digitalhouse.desafiomarveldh.model.Series;
import br.com.digitalhouse.desafiomarveldh.model.Thumbnail;

public class Converters {

    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }


    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Characters fromCharacters(String value) {
        Type listType = (Type) new TypeToken<Characters>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCharacters(Characters list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public List<Creators> fromListAttribute(String value) {
        Type listType = (Type) new TypeToken<List<Creators>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListAttribute(List<Creators> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Object fromObject(String value) {
        Type listType = (Type) new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromObject(Object list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public MarvelComics fromInstallments(String value) {
        Type listType = (Type) new TypeToken<MarvelComics>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public String fromInstallments(MarvelComics list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Data fromReviews(String value) {
        Type listType = (Type) new TypeToken<Data>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public String fromReviews(Data list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
    @TypeConverter
    public Thumbnail fromSeller(String value) {
        Type listType = (Type) new TypeToken<Thumbnail>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public String fromSeller(Thumbnail list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Image fromShipping(String value) {
        Type listType = (Type) new TypeToken<Image>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public String fromShipping(Image list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Series fromSellerAddress(String value) {
        Type listType = (Type) new TypeToken<Series>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromSellerAddress(Series list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }









}
