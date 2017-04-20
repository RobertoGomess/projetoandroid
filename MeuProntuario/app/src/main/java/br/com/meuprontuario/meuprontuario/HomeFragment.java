package br.com.meuprontuario.meuprontuario;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by betoj on 13/04/2017.
 */

public class HomeFragment extends Fragment {


        RecyclerView recyclerView;
        ReceitaAdapter receitaAdapter;
        List<Receita> listReceita;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInsatanceState){

            View view = inflater.inflate(R.layout.fragment_home,container,false);
            recyclerView = (RecyclerView)view.findViewById(R.id.RecycleReceitas);
            recyclerView.setHasFixedSize(true);


            LinearLayoutManager layoutManager = new LinearLayoutManager(HomeFragment.this);
            recyclerView.setLayoutManager(layoutManager);

            listReceita.add(new Receita (1,"20/20/20","20/21/20","Caganeira","Ele cagou muito"));
            listReceita.add(new Receita (2,"30/30/30","30/31/30","Caganeira Intermediária","Ele cagou muito mais"));
            listReceita.add(new Receita (2,"40/40/40","40/41/40","Caganeira Avançada","Ele cagou muito muito mais"));

            receitaAdapter = new ReceitaAdapter(listReceita);
            recyclerView.setAdapter(receitaAdapter);

            recyclerView.addItemDecoration(new DividerItemDecoration(HomeFragment.this,DividerItemDecoration.VERTICAL));

            return  view;
        }
    }
