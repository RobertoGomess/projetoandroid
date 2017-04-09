package br.com.meuprontuario.meuprontuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {

    //decaração do componentes
    TextView txtvInforAcesso;
    EditText txtNomeUsuario;
    EditText txtEmail;
    EditText txtvSenha;
    EditText txtConfirmaSenha;
    Switch switchTermos;
    Button btnCadastrarPasso2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Instaciando componentes
        txtvInforAcesso = (TextView)findViewById(R.id.txtViewInforAcesso);
        txtNomeUsuario = (EditText) findViewById(R.id.txtNomeUsuario);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtvSenha = (EditText)findViewById(R.id.txtSenha);
        txtConfirmaSenha = (EditText)findViewById(R.id.txtConfirmaSenha);
        switchTermos = (Switch)findViewById(R.id.switchTermos);
        btnCadastrarPasso2 = (Button)findViewById(R.id.btnCadastrarPasso2);

        //eventos>>>>
        btnCadastrarPasso2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastroPasso2 = new Intent(CadastroActivity.this,CadastroPasso2Activity.class);
                startActivity(cadastroPasso2);
            }
        });
    }
}
