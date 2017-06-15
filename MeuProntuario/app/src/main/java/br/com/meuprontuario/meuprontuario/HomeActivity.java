package br.com.meuprontuario.meuprontuario;

import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ImageButton btnAtendimentos;
    ImageButton btnHome;
    ImageButton btnEmergencia;

    BottomNavigationView navigation;
    public List<Receita> getListaReceita (){
        List<Receita> listReceita = new ArrayList<>();
        for (int x = 0; x<20; x++){
            Receita receita = new Receita(x,x+1+"/01/2017",x+1+"/03/2017","Doenca"+x,"Descricao"+x);
            listReceita.add(receita);
        }
        return listReceita;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAtendimentos = (ImageButton) findViewById(R.id.btn_atendimentos);
        btnEmergencia = (ImageButton) findViewById(R.id.btn_emergencia);
        btnHome = (ImageButton) findViewById(R.id.btn_home);

        btnAtendimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,AtendimentosActivity.class);
                startActivity(intent);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,AtendimentosActivity.class);
                startActivity(intent);
            }
        });
        btnEmergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,AtendimentosActivity.class);
                startActivity(intent);
            }
        });


        /*//instanciando os Buttom do menu de navagacao
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //chamando o metodo que verifica o buttom do menu que foi clicado
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //passando um buttom para ser o primeiro selecionado ao abrir o menu
        navigation.setSelectedItemId(R.id.navigation_home);
       */

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



 /*   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("homeFrag");
                    if (homeFragment==null){
                        homeFragment = new HomeFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frag_tela,homeFragment,"homeFrag");
                        ft.commit();
                    }

                    return true;
                case R.id.navigation_emergencia:
                   // mTextMessage.setText(R.string.title_emergencia);
                    EmergenciaFragment emergenciaFragment= (EmergenciaFragment)
                            getSupportFragmentManager().findFragmentByTag("emergenciaFrag");
                    if (emergenciaFragment==null){
                        emergenciaFragment = new EmergenciaFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frag_tela,emergenciaFragment,"emergenciaFrag");
                        ft.commit();
                    }

                    return true;
                case R.id.navigation_consultas:
                    //mTextMessage.setText(R.string.title_consultas);
                    ConsultasFragment consultasFragment= (ConsultasFragment)
                            getSupportFragmentManager().findFragmentByTag("consultaFrag");
                    if (consultasFragment==null){
                        consultasFragment = new ConsultasFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frag_tela,consultasFragment,"consultasFrag");
                        ft.commit();
                    }
                    return true;
                case R.id.navigation_perfil:
                    //mTextMessage.setText(R.string.title_perfil);
                    PerfilFragment perfilFragment= (PerfilFragment)
                            getSupportFragmentManager().findFragmentByTag("consultaFrag");
                    if (perfilFragment==null){
                        perfilFragment = new PerfilFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frag_tela,perfilFragment,"consultasFrag");
                        ft.commit();
                    }
                    return true;
            }
            return false;
        }

    };*/

}
