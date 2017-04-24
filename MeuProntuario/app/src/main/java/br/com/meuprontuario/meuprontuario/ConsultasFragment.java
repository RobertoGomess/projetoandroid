package br.com.meuprontuario.meuprontuario;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by betoj on 13/04/2017.
 */

public class ConsultasFragment extends Fragment implements RecycleViewOnClikeListenerHack {
    RecyclerView recyclerView;
    List<Receita> listReceita;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_consultas,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.rv_receitas);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager lln = new LinearLayoutManager(getActivity());
        lln.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lln);

        listReceita = ((HomeActivity)getActivity()).getListaReceita();
        ReceitaAdapter adapter =  new ReceitaAdapter(listReceita,getActivity());
        adapter.setRecycleViewOnClikeListenerHack(this);
        recyclerView.setAdapter(adapter);

        return  view;
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(),"CLICK NA POSIÇÃO "+ position,Toast.LENGTH_LONG).show();
    }
}
