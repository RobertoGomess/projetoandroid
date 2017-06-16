package br.com.meuprontuario.meuprontuario.PacoteReceita;

import android.content.Context;
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
        Toast.makeText(getActivity(),"position :"+position ,Toast.LENGTH_LONG).show();
    }
}
