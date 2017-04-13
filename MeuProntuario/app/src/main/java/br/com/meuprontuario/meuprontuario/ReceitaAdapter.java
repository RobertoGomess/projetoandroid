package br.com.meuprontuario.meuprontuario;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by betoj on 13/04/2017.
 */

public class ReceitaAdapter extends RecyclerView.Adapter<ReceitaAdapter.MyViewHolder> {

    private List<Receita> mListReceita;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView){
            super(itemView);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
