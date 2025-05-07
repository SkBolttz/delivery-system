package com.br.hiquez.delivery_system.Enum;

public enum StatusPedido {
    
    CRIADO("Pedido criado"),
    EM_ROTA("Pedido em rota"),
    ENTREGU("Pedido entregue"),
    CANCELADO("Pedido cancelado");

    private String nome;

    StatusPedido(String nome) {
        this.nome = nome;
    }
}
