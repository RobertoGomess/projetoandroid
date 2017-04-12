package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CadastroPasso3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_passo3);

        Button btn_pular = (Button)findViewById(R.id.btn_pular);

        btn_pular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(CadastroPasso3Activity.this,HomeActivity.class);
                startActivity(home);
            }
        });
    }
}
