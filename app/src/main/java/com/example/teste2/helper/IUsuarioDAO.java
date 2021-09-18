package com.example.teste2.helper;

import com.example.teste2.model.entities.User;

public interface IUsuarioDAO {

    public boolean salvar(User user);
    public boolean atualizar(User user);
    public boolean deletar(User user);
    public String buscar(String column);
}
