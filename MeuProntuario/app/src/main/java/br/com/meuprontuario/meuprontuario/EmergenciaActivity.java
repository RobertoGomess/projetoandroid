package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class EmergenciaActivity extends AppCompatActivity {

    private Intent tela;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tela = new Intent(EmergenciaActivity.this,HomeActivity.class);
                    startActivity(tela);
                    return true;
                case R.id.navigation_emergencia:
                    // já vai estar na tela
                    return true;
                /*case R.id.navigation_prontuario:
                    mTextMessage.setText(R.string.title_prontuario);
                    return true;*/
                case R.id.navigation_perfil:
                    tela = new Intent(EmergenciaActivity.this,PerfilActivity.class);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);
    }
}
