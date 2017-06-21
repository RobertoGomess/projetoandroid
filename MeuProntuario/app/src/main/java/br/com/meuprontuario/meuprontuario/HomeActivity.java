package br.com.meuprontuario.meuprontuario;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import br.com.meuprontuario.meuprontuario.PacoteReceita.Receita;
import br.com.meuprontuario.meuprontuario.PacoteReceita.ReceitasActivity;

public class HomeActivity extends AppCompatActivity {

    ImageButton btnReceitas;
    ImageButton btnHome;
    ImageButton btnEmergencia;
    Context context = this;
    int idPac;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //pegando a variavel da outra activity
        Intent i = getIntent();
        idPac =Integer.parseInt(i.getStringExtra("idPac"));

        btnHome = (ImageButton) findViewById(R.id.btn_home);
        btnEmergencia = (ImageButton) findViewById(R.id.btn_emergencia);
        btnReceitas = (ImageButton) findViewById(R.id.btn_receitas);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HomeActivity.this,ReceitasActivity.class);
                //startActivity(intent);
                Toast.makeText(context,"tela home" , Toast.LENGTH_LONG).show();
            }
        });
        btnEmergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EmergenciaActivity.class);
                startActivity(intent);
                //Toast.makeText(context, "Tela Emergencia" , Toast.LENGTH_LONG).show();
            }
        });

        btnReceitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ReceitasActivity.class);
                intent.putExtra("idPac",""+idPac);
                startActivity(intent);

            }
        });



        //instanciando tollbar personalizada
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar_home, menu);
        return true;
    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_Perfil:
                Toast.makeText(this, "perfil",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_configuracao:
                Toast.makeText(this, "configuração",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_FeedBack:
                Toast.makeText(this, "FeedBack",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_Termo:
                Toast.makeText(this, "Termos",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle("Sair")
                .setMessage("Deseja realmente sair do aplicativo?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Não", null)
                .show();
    }



}
