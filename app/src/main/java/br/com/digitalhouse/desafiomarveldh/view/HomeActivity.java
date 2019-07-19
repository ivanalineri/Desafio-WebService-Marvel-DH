package br.com.digitalhouse.desafiomarveldh.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import br.com.digitalhouse.desafiomarveldh.R;
import br.com.digitalhouse.desafiomarveldh.adapters.RecyclerViewMarvelAdapter;
import br.com.digitalhouse.desafiomarveldh.model.Result;
import br.com.digitalhouse.desafiomarveldh.viewmodel.MarvelViewModel;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewComics;
    private MarvelViewModel comicsViewModel;
    private RecyclerViewMarvelAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void initViews() {
        comicsViewModel = ViewModelProviders.of(this).get(MarvelViewModel.class);

//        recyclerViewComics = findViewById(R.id.recyclerViewComics);
//        progressBar = findViewById(R.id.progressBar);

        adapter = new RecyclerViewMarvelAdapter(new ArrayList<>());

        recyclerViewComics.setHasFixedSize(true);
        recyclerViewComics.setItemViewCacheSize(20);
        recyclerViewComics.setAdapter(adapter);
        recyclerViewComics.setLayoutManager(new GridLayoutManager(this, 3));


    }
}
