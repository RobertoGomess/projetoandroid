package br.com.meuprontuario.meuprontuario;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.concurrent.ExecutionException;

import br.com.meuprontuario.meuprontuario.PacoteReceita.Receita;
import br.com.meuprontuario.meuprontuario.PacoteReceita.ReceitasActivity;
import br.com.meuprontuario.meuprontuario.PacoteReceita.ReceitasFragment;

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

    ProgressDialog progressDialog;
    Context context = this;
    boolean login;
    Paciente paciente = new Paciente();

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
        //instanciando o Tollbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
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

                progressDialog = ProgressDialog.show(LoginActivity.this, "Aguarde", "Baixando informações...");


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            lerJson();
                            progressDialog.dismiss();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.dismiss();
                                    Toast.makeText(context,paciente.getNome(),Toast.LENGTH_LONG).show();

                                    /*ReceitasFragment fragment = (ReceitasFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
                                    if (fragment==null){
                                        fragment = new ReceitasFragment();
                                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                        ft.replace(R.id.rl_frag_receita, fragment , "mainFrag");
                                        ft.commit();
                                    }*/
                                }
                            });


                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();



                //code condicao...
                //condicao para chamar a outra tela...
                    /*login=true;
                    if (login==true){
                        Intent home = new Intent(LoginActivity.this,HomeActivity.class);
                        //abre a tela home
                        startActivity(home);
                        //finaliza a tela atual
                        finish();
                }*/

            }
        });


    }
    public void lerJson() throws ExecutionException, InterruptedException, JSONException {

        //se comunicando com o servidor
        BaseRequester baseRequester = new BaseRequester();
        baseRequester.setUrl("http://www.betojunior.com.br/webservice/PacotePaciente/pacienteLogin.php");
        baseRequester.setContext(context);

        //Caso precise enviar dados para o servidor, utilize o jsonput
        Paciente filtro = new Paciente();
        filtro.setEmail(txtEmail.getText().toString());
        filtro.setSenha(txtSenha.getText().toString());
        //Toast.makeText(context,filtro.getEmail().toString(),Toast.LENGTH_LONG).show();


        JSONObject jsonPut = new JSONObject();
        jsonPut.put("email", filtro.getEmail());
        jsonPut.put("senha", filtro.getSenha());

        baseRequester.setJsonString(jsonPut.toString());

        //recuperando o json em formato tetxo
        String jsonString = baseRequester.execute(baseRequester).get();

        //transformando o json texto em JsonObject
        JSONObject jsonObject = new JSONObject(jsonString);

        paciente.setId(Integer.parseInt(jsonObject.get("id").toString()));
        paciente.setNome(jsonObject.get("nome").toString());
        paciente.setSexo(Integer.parseInt(jsonObject.get("sexo").toString()));
        paciente.setTelefone(jsonObject.getString("telefone").toString());
        paciente.setCpf(jsonObject.getString("cpf").toString());
        paciente.setSus(Integer.parseInt(jsonObject.get("sus").toString()));
        paciente.setSenha(jsonObject.getString("senha").toString());
        paciente.setEmail(jsonObject.getString("email").toString());
        paciente.setEndereco_id(Integer.parseInt(jsonObject.getString("endereco_id").toString()));


        /*paciente.setId(Integer.parseInt(jsonObject.get("").toString()));
        paciente.setId(Integer.parseInt(jsonObject.get("").toString()));
        paciente.setId(Integer.parseInt(jsonObject.get("").toString()));
        paciente.setId(Integer.parseInt(jsonObject.get("").toString()));*/

        //transformando o json texto em JsonOArray
        //JSONArray jsonArrayUsers = new JSONArray(jsonString);

        /*for (int i=0; i < jsonArrayUsers.length(); i++) {

            JSONObject jsonObjectUsuario = jsonArrayUsers.getJSONObject(i);

            Receita receita = new Receita();

            receita.setId(Integer.parseInt(jsonObjectUsuario.get("id").toString()));
            receita.setData(jsonObjectUsuario.getString("data").toString());
            receita.setValidade(jsonObjectUsuario.getString("validade").toString());
            receita.setDoenca(jsonObjectUsuario.getString("doenca").toString());
            receita.setDescricao(jsonObjectUsuario.getString("descricao").toString());

            listReceita.add(receita);
        }*/

    }
}
