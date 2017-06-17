package br.com.meuprontuario.meuprontuario.PacoteReceita;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.meuprontuario.meuprontuario.CadastroActivity;
import br.com.meuprontuario.meuprontuario.LoginActivity;
import br.com.meuprontuario.meuprontuario.R;

/**
 * Created by betoj on 13/04/2017.
 */

public class ReceitasFragment extends Fragment implements RecycleViewOnClikeListenerHack {

    Context context = this.getContext();

    private RecyclerView recyclerView;
    private ArrayList<Receita> listReceita = new ArrayList<Receita>();
    private ReceitaAdapter receitaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_receitas,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.rv_receitas);
        recyclerView.setHasFixedSize(true);

            LinearLayoutManager lln = new LinearLayoutManager(getActivity());
            lln.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(lln);

            listReceita = ((ReceitasActivity) getActivity()).getListReceita();
            receitaAdapter= new ReceitaAdapter(listReceita,getActivity());
            receitaAdapter.setRecyclerViewOnClick(this);
            recyclerView.setAdapter(receitaAdapter);

            return  view;
    }


    @Override


    public void onClickListener(View view, int position) {
        Intent telaReceita = new Intent(this.getContext(),DetalhesReceita.class);
        telaReceita.putExtra("DataReceita",listReceita.get(position).getData());
        telaReceita.putExtra("Descricao",listReceita.get(position).getDescricao());
        telaReceita.putExtra("Data",listReceita.get(position).getData());
        telaReceita.putExtra("Doenca",listReceita.get(position).getDoenca());
        telaReceita.putExtra("Validade",listReceita.get(position).getValidade());
        startActivity(telaReceita);
    }
}
