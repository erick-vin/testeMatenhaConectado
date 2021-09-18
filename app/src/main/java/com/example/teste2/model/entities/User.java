package com.example.teste2.model.entities;

public class User {

    private String nome;
    private String senha;
    private boolean matenhaConect = false;

    public User(){
    }

    public User(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isMatenhaConect() {
        return matenhaConect;
    }

    public void setMatenhaConect(boolean matenhaConect) {
        this.matenhaConect = matenhaConect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (nome != null ? !nome.equals(user.nome) : user.nome != null) return false;
        return senha != null ? senha.equals(user.senha) : user.senha == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }
}
