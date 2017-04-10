package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by betoj on 07/04/2017.
 */

public class EsqueceuSenhaActivity extends AppCompatActivity {

    private EditText txtEsqueceuEmail;
    private Button btnEsqueceuSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);

        //instanciando componentes

        txtEsqueceuEmail = (EditText)findViewById(R.id.txtEsqueceuEmail) ;
        btnEsqueceuSenha = (Button)findViewById(R.id.btnEsqueceuSenha);

        //pegando valores da Loginactivity

        Intent i = getIntent();
        String valor = i.getStringExtra("VALOR");
        Toast.makeText(getApplicationContext(),valor,Toast.LENGTH_LONG).show();

        //

    }
}
