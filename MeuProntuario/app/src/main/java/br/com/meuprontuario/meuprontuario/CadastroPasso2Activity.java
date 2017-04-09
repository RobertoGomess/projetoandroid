package br.com.meuprontuario.meuprontuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroPasso2Activity extends AppCompatActivity {

    //declaracao de componentes
    TextView txtvInforPessoa;
    EditText txtNome;
    EditText txtTelefone;
    EditText txtCpf;
    EditText txtDataNascimento;
    Button btnConcluir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_passo2);

        //instanciando componentes
        txtvInforPessoa = (TextView)findViewById(R.id.txtvInforPessoa);
        txtNome = (EditText)findViewById(R.id.txtNome);
        txtTelefone = (EditText)findViewById(R.id.txtTelefone);
        txtCpf = (EditText)findViewById(R.id.txtCpf);
        txtDataNascimento = (EditText)findViewById(R.id.txtDataNascimento);
        btnConcluir = (Button)findViewById(R.id.btnConcluir);

        //eventos
        btnConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click do botao concluir" ,Toast.LENGTH_LONG).show();
            }
        });


    }
}
