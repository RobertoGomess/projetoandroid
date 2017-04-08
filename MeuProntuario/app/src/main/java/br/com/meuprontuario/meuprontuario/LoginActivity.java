package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by betoj on 07/04/2017.
 */

public class LoginActivity extends AppCompatActivity {

    //declaração dos elementos
    Button btnEntrar;
    EditText txtEmail;
    EditText txtSenha;
    TextView txtvEsqueceSenha;
    boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //instanciando elementos
        btnEntrar = (Button)findViewById(R.id.btn_Entrar);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtSenha = (EditText)findViewById(R.id.txtSenha);
        txtvEsqueceSenha = (TextView) findViewById(R.id.textViewEsqueceuSenha);
        Button btnCadastrar = (Button)findViewById(R.id.button_cadastrar);

        //Eventos click

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent cadastro = new Intent(LoginActivity.this,CadastroActivity.class);
                    startActivity(cadastro);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code condicao...
                //condicao para chamar a outra tela...
                login=true;
                if (login==true){
                    Intent home = new Intent(LoginActivity.this,HomeActivity.class);
                    //abre a tela home
                    startActivity(home);
                    //finaliza a tela atual
                    finish();
                }

            }
        });

        txtvEsqueceSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent esqueceuSenha = new Intent(LoginActivity.this,EsqueceuSenhaActivity.class);
                //passando valor para a outra activity
                esqueceuSenha.putExtra("VALOR",txtEmail.getText().toString());
                startActivity(esqueceuSenha);
            }
        });


    }
}
