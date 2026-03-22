package com.as.gerenciamento_pedidos.models;

import com.as.gerenciamento_pedidos.enums.PedidoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_PEDIDO")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_pedido")
    private LocalDateTime data;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Enumerated(EnumType.STRING)
    private PedidoEnum status;

    public PedidoModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoEnum getStatus() {
        return status;
    }

    public void setStatus(PedidoEnum status) {
        this.status = status;
    }
}
