package com.br.hiquez.delivery_system.Enum;

public enum CategoriaEntrega {
    CARRO("Carro"),
    MOTO("Moto"),
    BICICLETA("Bicicleta");

    private String nome;

    CategoriaEntrega(String nome) {
        this.nome = nome;
    }
}
