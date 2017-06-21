package br.com.meuprontuario.meuprontuario;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import br.com.meuprontuario.meuprontuario.PacoteReceita.MetodosHTTP;
import br.com.meuprontuario.meuprontuario.PacoteReceita.Receita;

/**
 * Created by betoj on 07/04/2017.
 */

public class LoginActivity extends AppCompatActivity {

    //declaração dos elementos

    private Button btnCadastrar;
    private Button btnEntrar;
    public EditText txtEmail;
    public EditText txtSenha;
    private Switch switchLembraSenha;
    private TextView txtvEsqueceSenha;

    //declaração variaveis
    ProgressDialog pdia;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //instanciando elementos

        txtEmail = (EditText) findViewById(R.id.txtNomeUsuario);
        txtSenha = (EditText) findViewById(R.id.txtConfirmaSenha);
        switchLembraSenha = (Switch) findViewById(R.id.switchLembraSenha);
        txtvEsqueceSenha = (TextView) findViewById(R.id.textViewEsqueceuSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnEntrar = (Button) findViewById(R.id.btn_Entrar);
        //instanciando o Tollbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        context = this;

        //Eventos click

        txtvEsqueceSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent esqueceuSenha = new Intent(LoginActivity.this, EsqueceuSenhaActivity.class);
                //passando valor para a outra activity
                esqueceuSenha.putExtra("VALOR", txtEmail.getText().toString());
                startActivity(esqueceuSenha);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastro = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(cadastro);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veriifyShared();
            }
        });


    }
    public void veriifyShared(){

        new sendLogin().execute();  /** Executa o nosso asyncTask **/

    }

    private class sendLogin extends AsyncTask<Void, Void, Paciente> {
        Paciente filtro = new Paciente();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            filtro.setEmail(txtEmail.getText().toString());
            filtro.setSenha(txtSenha.getText().toString());
            pdia = new ProgressDialog(LoginActivity.this);
            pdia.setMessage("Loading...");
            pdia.show();
        }

        @Override
        protected Paciente doInBackground(Void... params) {
            Paciente rt = new Paciente();
            try {
                String returnStr = "";
                URL url = new URL("http://192.168.1.5/webservice/webservice/PacotePaciente/pacienteLogin.php");

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestMethod(String.valueOf(MetodosHTTP.POST));
                urlConnection.setDoInput(true); /**Informa que iremos realizar operacao de leitura nessa determinada conexão*/
                urlConnection.setDoOutput(true);/**Informa que iremos realizar operacao de escrita nessa determinada conexão, ou seja, iremos enviar alguma parametro no seu corpo*/

                /**
                 * O nosso servidor espera um json, entao vamos converter a nossa string em um objeto JsonObject
                 */
                JSONObject objJson = new JSONObject();
                objJson.put("email", filtro.getEmail()  );
                objJson.put("senha", filtro.getSenha());

                //JSONObject json = new JSONObject();
                //json.put("json",objJson );

                /**
                 * Vamos transformar agora o nosso jsonObjet em bytes para enviar para o servidor
                 */
                OutputStream out = urlConnection.getOutputStream();
                out.write(objJson.toString().getBytes());
                out.close();

                if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_BAD_REQUEST) {
                    returnStr = Uteis.bytesParaString(urlConnection.getInputStream());
                    urlConnection.disconnect();
                }

                rt = convertJson(returnStr);


            } catch (Exception e) {
                Log.e("Erro json", e.getMessage());
                rt.setStatus("3");
                rt.setMessagem("Falha ao conectar, verifique sua conexão.");
                return rt;
            }
            return rt;
        }
        @Override
        protected void onPostExecute(Paciente p) {
            super.onPostExecute(p);
            pdia.dismiss();
            //se o
            if (p.getId()>0){
                Toast.makeText(context, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                intent.putExtra("idPac",""+p.getId());
                startActivity(intent);
            }else{
                Toast.makeText(context, p.getMessagem(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    public Paciente convertJson(String json){
        Paciente paciente = new Paciente();

        try{


            JSONObject jsonReturnApi = new JSONObject(json);

            paciente.setId(Integer.parseInt(jsonReturnApi.getString("id")));
            paciente.setNome(jsonReturnApi.getString("nome"));
            paciente.setSexo(Integer.parseInt(jsonReturnApi.getString("sexo").toString()));
            paciente.setTelefone(jsonReturnApi.getString("telefone"));
            paciente.setCpf(jsonReturnApi.getString("cpf"));
            paciente.setSus(Long.parseLong(jsonReturnApi.getString("sus")) );
            paciente.setEmail(jsonReturnApi.getString("email"));
            paciente.setSenha(jsonReturnApi.getString("senha"));
            paciente.setEndereco_id(Integer.parseInt(jsonReturnApi.getString("endereco_id").toString()));
            paciente.setStatus(jsonReturnApi.getString("status"));
            paciente.setMessagem(jsonReturnApi.getString("messagem"));

            return paciente;

        } catch (Exception e){
            Log.e("Erro json", e.getMessage());
            return paciente;
        }
    }


}
