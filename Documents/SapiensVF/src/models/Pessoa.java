package models;

public class Pessoa {
    protected String nome;
    protected String email;
    protected String senha;

    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getNome() { return nome; }
}
