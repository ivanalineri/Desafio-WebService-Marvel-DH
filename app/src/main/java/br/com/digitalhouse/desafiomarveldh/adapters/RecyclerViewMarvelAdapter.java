package br.com.digitalhouse.desafiomarveldh.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.digitalhouse.desafiomarveldh.R;

public class RecyclerViewMarvelAdapter extends RecyclerView.Adapter<RecyclerViewMarvelAdapter.ViewHolder> {


    public RecyclerViewMarvelAdapter(ArrayList<Object> objects) {

    }

    @NonNull
    @Override
    public RecyclerViewMarvelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.comic_item_recyclerview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMarvelAdapter.ViewHolder holder, int position) {



    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
