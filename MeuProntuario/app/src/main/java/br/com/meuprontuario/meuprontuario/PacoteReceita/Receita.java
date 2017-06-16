package br.com.meuprontuario.meuprontuario.PacoteReceita;

import java.util.Date;

/**
 * Created by aluno on 19/04/2017.
 */

public class Receita {

    public Receita(){

    }

    public Receita(int id, String data, String validade, String doenca, String descricao) {
        this.id = id;
        this.data = data;
        this.validade = validade;
        this.doenca = doenca;
        this.descricao = descricao;
    }

    private int id;
    private String data;
    private String validade;
    private String doenca;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
