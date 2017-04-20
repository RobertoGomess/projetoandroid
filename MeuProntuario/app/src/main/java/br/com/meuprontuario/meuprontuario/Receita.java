package br.com.meuprontuario.meuprontuario;

import java.util.Date;

/**
 * Created by aluno on 19/04/2017.
 */

public class Receita {

    public Receita(int id, Date data, Date validade, String doenca, String descricao) {
        this.id = id;
        this.data = data;
        this.validade = validade;
        this.doenca = doenca;
        this.descricao = descricao;
    }

    private int id;
    private Date data;
    private Date validade;
    private String doenca;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
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
