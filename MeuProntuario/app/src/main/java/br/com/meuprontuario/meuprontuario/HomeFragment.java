package br.com.meuprontuario.meuprontuario;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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

            return view;
        }
    }
