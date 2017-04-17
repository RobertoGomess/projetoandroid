package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by betoj on 07/04/2017.
 */

public class LoginActivity extends AppCompatActivity {

    //declaração dos elementos

    private Button btnCadastrar;
    private Button btnEntrar;
    private EditText txtEmail;
    private EditText txtSenha;
    private Switch switchLembraSenha;
    private TextView txtvEsqueceSenha;

    //declaração variaveis

    boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //instanciando elementos

        txtEmail = (EditText)findViewById(R.id.txtNomeUsuario);
        txtSenha = (EditText)findViewById(R.id.txtConfirmaSenha);
        switchLembraSenha = (Switch)findViewById(R.id.switchLembraSenha);
        txtvEsqueceSenha = (TextView) findViewById(R.id.textViewEsqueceuSenha);
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);
        btnEntrar = (Button)findViewById(R.id.btn_Entrar);

        //Eventos click

        txtvEsqueceSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent esqueceuSenha = new Intent(LoginActivity.this,EsqueceuSenhaActivity.class);
                //passando valor para a outra activity
                esqueceuSenha.putExtra("VALOR",txtEmail.getText().toString());
                startActivity(esqueceuSenha);
            }
        });

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
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();
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


    }
}
