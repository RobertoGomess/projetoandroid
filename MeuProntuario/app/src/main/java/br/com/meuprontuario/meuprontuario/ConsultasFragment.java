package br.com.meuprontuario.meuprontuario;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by betoj on 13/04/2017.
 */

public class ConsultasFragment extends Fragment implements RecycleViewOnClikeListenerHack {
    public Context context = this.getContext();
    public ProgressDialog progressDialog;
    ReceitaAdapter receitaAdapter;


    RecyclerView recyclerView;
    ArrayList<Receita> listReceita = new ArrayList<Receita>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        progressDialog = ProgressDialog.show(this.getActivity(), "Lista", "Carregando...");

        View view = inflater.inflate(R.layout.fragment_consultas,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.rv_receitas);
        recyclerView.setHasFixedSize(true);
        //final ReceitaAdapter adapter =

        try {


            LinearLayoutManager lln = new LinearLayoutManager(getActivity());
            lln.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(lln);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lerJson();

                        progressDialog.dismiss();

                        //listando receitas
                        //listReceita = ((HomeActivity)getActivity()).getListaReceita();



                    /* (int i = 0; i < listReceita.size(); i++) {

                        Receita receita = new Receita();
                        receita.setId(listReceita.get(i).getId());
                        receita.setDoenca(listReceita.get(i).getDoenca());
                        receita.setDescricao(listReceita.get(i).getDescricao());

                        //receita.setEmail(listReceita.get(i).getEmail());
                        final String concat = receita.getId() + " " + receita.getDescricao() + " " + receita.getDoenca();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                            recyclerView.setAdapter(receitaAdapter);
                                progressDialog.dismiss();
                                Toast.makeText(context, concat, Toast.LENGTH_LONG).show();
                            }
                        });
                    }*/

                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        loadAdapter();

                    }
                }
            }).start();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return  view;
        }


    }

    public void loadAdapter() {
        recyclerView.setAdapter(receitaAdapter);
        receitaAdapter.setRecycleViewOnClikeListenerHack(this);
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(),"CLICK NA POSIÇÃO "+ position,Toast.LENGTH_LONG).show();
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



            /*receita.setNome(jsonObjectUsuario.get("nome").toString());
            receita.setSexo(Integer.parseInt(jsonObjectUsuario.get("sexo").toString()));
            receita.setTelefone(jsonObjectUsuario.get("telefone").toString());
            receita.setCpf(jsonObjectUsuario.get("cpf").toString());
            receita.setSus(jsonObjectUsuario.get("sus").toString());
            receita.setSenha(jsonObjectUsuario.get("senha").toString());
            receita.setEmail(jsonObjectUsuario.get("email").toString());
            receita.setEnderecoId(Integer.parseInt(jsonObjectUsuario.get("endereco_id").toString()));*/


            listReceita.add(receita);
        }

        receitaAdapter = new ReceitaAdapter(listReceita,getActivity());



    }
}
