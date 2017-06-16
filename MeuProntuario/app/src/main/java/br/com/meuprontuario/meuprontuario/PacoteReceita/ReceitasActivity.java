package br.com.meuprontuario.meuprontuario.PacoteReceita;


import android.support.v4.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.content.Context;

import br.com.meuprontuario.meuprontuario.BaseRequester;
import br.com.meuprontuario.meuprontuario.R;

public class ReceitasActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    Context context = this;

    ArrayList<Receita> listReceita = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);


        //Toast.makeText(this,"tela atendimentos",Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
        ConsultasFragment consultasFragment = (ConsultasFragment) getSupportFragmentManager().findFragmentByTag("frag");
        if (consultasFragment==null){
            consultasFragment = new ConsultasFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_frag_receita,consultasFragment,"receitaFrag");
            ft.commit();
        }

        */

        progressDialog = ProgressDialog.show(ReceitasActivity.this, "Aguarde", "Baixando informações...");


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lerJson();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                                ReceitasFragment fragment = (ReceitasFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
                                if (fragment==null){
                                    fragment = new ReceitasFragment();
                                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                    ft.replace(R.id.rl_frag_receita, fragment , "mainFrag");
                                    ft.commit();
                                }
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


    }
    public ArrayList<Receita> getListReceita (){
        return listReceita;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case 16908332:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void lerJson() throws ExecutionException, InterruptedException, JSONException {

        //se comunicando com o servidor
        BaseRequester baseRequester = new BaseRequester();
        baseRequester.setUrl("http://www.betojunior.com.br/webservice/PacoteReceita/listaReceita.php");
        baseRequester.setContext(context);

        //Caso precise enviar dados para o servidor, utilize o jsonput
        //JSONObject jsonPut = new JSONObject();
        //jsonPut.put("login", login);
        //jsonPut.put("senha", senha);
        //baseRequester.setJsonString(jsonPut.toString());

        //recuperando o json em formato tetxo
        String jsonString = baseRequester.execute(baseRequester).get();

        //transformando o json texto em JsonObject
        //JSONObject jsonObject = new JSONObject(jsonString);

        //transformando o json texto em JsonOArray
        JSONArray jsonArrayUsers = new JSONArray(jsonString);

        for (int i=0; i < jsonArrayUsers.length(); i++) {

            JSONObject jsonObjectUsuario = jsonArrayUsers.getJSONObject(i);

            Receita receita = new Receita();

            receita.setId(Integer.parseInt(jsonObjectUsuario.get("id").toString()));
            receita.setData(jsonObjectUsuario.getString("data").toString());
            receita.setValidade(jsonObjectUsuario.getString("validade").toString());
            receita.setDoenca(jsonObjectUsuario.getString("doenca").toString());
            receita.setDescricao(jsonObjectUsuario.getString("descricao").toString());

            listReceita.add(receita);
        }

    }


}
