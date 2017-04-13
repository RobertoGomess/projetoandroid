package br.com.meuprontuario.meuprontuario;



public class Receita {
    private String nome;
    private String date;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Receita(String nome, String date, String descricao) {
        this.nome = nome;
        this.date = date;
        this.descricao = descricao;
    }
}
