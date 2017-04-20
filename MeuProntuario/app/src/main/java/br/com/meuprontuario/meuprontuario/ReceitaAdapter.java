package br.com.meuprontuario.meuprontuario;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aluno on 19/04/2017.
 */

public class ReceitaAdapter extends RecyclerView.Adapter<ListViewHolder>{

    private List<Receita> listReceitas;

    public ReceitaAdapter(List<Receita> receitas){
        listReceitas = receitas;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.linha_receita,parent,false));
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.textViewDoenca.setText(listReceitas.get(position).getDoenca());
        holder.textViewDescricao.setText(listReceitas.get(position).getDescricao());
        holder.textViewValidade.setText(listReceitas.get(position).getValidade().toString());
        holder.textViewData.setText(listReceitas.get(position).getData().toString());
    }

    @Override
    public int getItemCount() {
        return listReceitas.size();
    }
}
