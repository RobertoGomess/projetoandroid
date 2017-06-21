package br.com.meuprontuario.meuprontuario;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.meuprontuario.meuprontuario.PacoteReceita.ReceitasFragment;

public class EmergenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EmergenciaFragment fragment = (EmergenciaFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if (fragment==null){
            fragment = new EmergenciaFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_frag_emergencia, fragment , "mainFrag");
            ft.commit();
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case 16908332:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
