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
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //instanciando os Buttom do menu de navagacao
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //chamando o metodo que verifica o buttom do menu que foi clicado
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //passando um buttom para ser o primeiro selecionado ao abrir o menu
        navigation.setSelectedItemId(R.id.navigation_home);
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
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
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

    };

}
