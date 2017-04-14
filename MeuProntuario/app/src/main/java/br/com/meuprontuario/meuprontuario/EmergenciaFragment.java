package br.com.meuprontuario.meuprontuario;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * Created by betoj on 13/04/2017.
 */

public class EmergenciaFragment extends Fragment {
    private FloatingActionButton btnLigar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_emergencia,container,false);
        btnLigar = (FloatingActionButton)view.findViewById(R.id.floatingActionButtonLigar);
        btnLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri uri = Uri.parse("tel:192");
                    Intent i = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getContext(),"Não foi possível realizar a ligação. "+e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }


}

