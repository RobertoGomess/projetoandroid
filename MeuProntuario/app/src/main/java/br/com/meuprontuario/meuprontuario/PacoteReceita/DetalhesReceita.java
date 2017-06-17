package br.com.meuprontuario.meuprontuario.PacoteReceita;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.meuprontuario.meuprontuario.R;

public class DetalhesReceita extends AppCompatActivity {

    private TextView textView_doenca;
    private TextView textView_descricao;
    private TextView textView_validade;
    private TextView textView_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_receita);
        Intent Dados = getIntent();
        textView_doenca = (TextView)findViewById(R.id.textView_doenca);
        textView_data = (TextView)findViewById(R.id.textView_data);
        textView_descricao = (TextView) findViewById(R.id.textView_descricao);
        textView_validade = (TextView) findViewById(R.id.textView_validade);

        textView_validade.setText("Validade da Receita: "+Dados.getStringExtra("Validade"));
        textView_data.setText("Data da Receita: "+Dados.getStringExtra("Data"));
        textView_doenca.setText("Doença: "+Dados.getStringExtra("Doenca"));
        textView_descricao.setText("Descrição: "+Dados.getStringExtra("Descricao"));
    }
}
