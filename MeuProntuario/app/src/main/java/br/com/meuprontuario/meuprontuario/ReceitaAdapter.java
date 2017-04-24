package br.com.meuprontuario.meuprontuario;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluno on 19/04/2017.
 */

public class ReceitaAdapter extends RecyclerView.Adapter<ReceitaAdapter.MyViewHolder>{

    private List<Receita> mListaReceica;
    private LayoutInflater mLayoutInflater;
    private RecycleViewOnClikeListenerHack recycleViewOnClikeListenerHack;

    public ReceitaAdapter (List<Receita> mListaReceica, Context context){
        this.mListaReceica = mListaReceica;

        this.mLayoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtData;
        public TextView txtValidade;
        public TextView txtDoenca;
        public TextView txtDescrico;

        public MyViewHolder(View itemView){
            super(itemView);
            txtData = (TextView)itemView.findViewById(R.id.txt_data);
            txtDoenca = (TextView)itemView.findViewById(R.id.txt_doenca);
            txtDescrico = (TextView)itemView.findViewById(R.id.txt_descricao);
            txtValidade = (TextView)itemView.findViewById(R.id.txt_validade);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (recycleViewOnClikeListenerHack != null){
                recycleViewOnClikeListenerHack.onClickListener(v,getAdapterPosition());
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.linha_receita,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtData.setText(mListaReceica.get(position).getData());
        holder.txtDescrico.setText(mListaReceica.get(position).getDescricao());
        holder.txtDoenca.setText(mListaReceica.get(position).getDoenca());
        holder.txtValidade.setText(mListaReceica.get(position).getValidade());

    }

    @Override
    public int getItemCount()
    {
        return mListaReceica.size();
    }
    public void setRecycleViewOnClikeListenerHack(RecycleViewOnClikeListenerHack recycleViewOnClikeListenerHack){
        this.recycleViewOnClikeListenerHack = recycleViewOnClikeListenerHack;
    }


}
