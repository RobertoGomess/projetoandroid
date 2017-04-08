package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnCadastrarPasso2 = (Button)findViewById(R.id.button_cadastrar);

        btnCadastrarPasso2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastroPasso2 = new Intent(CadastroActivity.this,CadastroPasso2Activity.class);
                startActivity(cadastroPasso2);
            }
        });
    }
}
