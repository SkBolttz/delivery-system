package com.br.hiquez.delivery_system.Entity;

import java.time.LocalDateTime;
import com.br.hiquez.delivery_system.Enum.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "tb_entrega")
public class Entrega {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private LocalDateTime dataSaida;
    @NotNull
    private LocalDateTime dataEntregaPrevista;
    @NotNull
    private StatusPedido status;
    @ManyToOne
    private Entregador entregador;
    @OneToOne
    private Pedido pedido;
    @ManyToOne
    private Cliente cliente;
}
