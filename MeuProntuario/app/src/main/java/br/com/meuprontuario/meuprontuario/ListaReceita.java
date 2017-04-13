package br.com.meuprontuario.meuprontuario;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by aluno on 12/04/2017.
 */

public class ListaReceita extends RecyclerView.ViewHolder {
    TextView textViewNome;
    TextView textViewData;
    TextView textViewDescricao;
    public ListaReceita(View intentView){
        super(intentView);

        textViewNome = (TextView)intentView.findViewById(R.id.textViewNome);
        textViewData = (TextView)intentView.findViewById(R.id.textViewData);
        textViewDescricao = (TextView)intentView.findViewById(R.id.textViewDescricao);

    }

}
