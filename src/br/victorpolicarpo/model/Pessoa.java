package br.victorpolicarpo.model;

public class Pessoa {
    private static int contadorId = 0;
    private final int id;
    private String nome;
    private int idade;
    private String email;

    public Pessoa(String nome, int idade, String email) {
        Pessoa.contadorId ++;
        this.id = contadorId;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

}
