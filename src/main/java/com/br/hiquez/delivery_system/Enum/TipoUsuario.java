package com.br.hiquez.delivery_system.Enum;

public enum TipoUsuario {
    CLIENTE("Cliente"),
    ENTREGADOR("Entregador"),
    ADMIN("Administrador");

    private String nome;

    TipoUsuario(String nome) {
        this.nome = nome;
    }
}
