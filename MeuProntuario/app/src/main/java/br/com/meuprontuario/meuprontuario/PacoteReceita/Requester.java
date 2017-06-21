package br.com.meuprontuario.meuprontuario.PacoteReceita;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;

import br.com.meuprontuario.meuprontuario.HomeActivity;
import br.com.meuprontuario.meuprontuario.LoginActivity;
import br.com.meuprontuario.meuprontuario.Paciente;
import br.com.meuprontuario.meuprontuario.Uteis;

/**
 * Created by aluno on 21/06/2017.
 */

public class Requester extends AsyncTask<Void, Void, String> {

    public String urli;
    public JSONObject jsonObjectPut;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //filtro.setEmail(txtEmail.getText().toString());
        //filtro.setSenha(txtSenha.getText().toString());
        //pdia = new ProgressDialog(LoginActivity.this);
        //pdia.setMessage("Loading...");
        //pdia.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        //Paciente rt = new Paciente();
        try {
            String returnStr = "";
           // URL url = new URL("http://betojunior.com.br/webservice/PacotePaciente/pacienteLogin.php");
            URL url = new URL(urli);

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
            JSONObject objJson = jsonObjectPut;
            //JSONObject objJson = new JSONObject();
            //objJson.put("email", filtro.getEmail()  );
            //objJson.put("senha", filtro.getSenha());

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

            //rt = convertJson(returnStr);
            return returnStr;


        } catch (Exception e) {
            Log.e("Erro json", e.getMessage());
            //rt.setStatus("3");
            //rt.setMessagem("Falha ao conectar, verifique sua conexão.");
            JSONObject jsonObjectErro = new JSONObject();
            try {
                jsonObjectErro.put("status", "3");
                jsonObjectErro.put("mensagem", "Falha ao conectar, verifique sua conexão.");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }

            return jsonObjectErro.toString();
        }
        //return "";
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //pdia.dismiss();
        //se o
        /*if (p.getId()>0){
            Toast.makeText(context, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            intent.putExtra("idPac",""+p.getId());
            startActivity(intent);
        }else{
            Toast.makeText(context, p.getMessagem(), Toast.LENGTH_SHORT).show();
        }*/
    }
}
