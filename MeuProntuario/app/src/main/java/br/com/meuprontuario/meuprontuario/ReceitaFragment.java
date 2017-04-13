package br.com.meuprontuario.meuprontuario;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by betoj on 13/04/2017.
 */

public class ReceitaFragment extends Fragment {

    private RecyclerView nRecyclerView;
    private List<Receita>  nListaReceita;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInsatanceState){

        View view = inflater.inflate(R.layout.fragment_receita,container,false);
        nRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_receita);
        nRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        nRecyclerView.setLayoutManager(llm);

        return view;
    }

}
