package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class PerfilActivity extends AppCompatActivity {

    private Intent tela;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tela = new Intent(PerfilActivity.this,HomeActivity.class);
                    startActivity(tela);
                    return true;
                case R.id.navigation_emergencia:
                    tela = new Intent(PerfilActivity.this,EmergenciaActivity.class);
                    startActivity(tela);
                    return true;
                /*case R.id.navigation_prontuario:
                    mTextMessage.setText(R.string.title_prontuario);
                    return true;*/
                case R.id.navigation_perfil:
                    // já vai estar na tela
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

    }
}
