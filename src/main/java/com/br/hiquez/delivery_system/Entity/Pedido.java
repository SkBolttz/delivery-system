package com.br.hiquez.delivery_system.Entity;

import com.br.hiquez.delivery_system.Enum.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private StatusPedido status;
    @NotBlank
    private String nomeProduto;
    private String descricao;
    @NotNull
    private double valor;
}
