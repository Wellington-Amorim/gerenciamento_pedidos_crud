package com.as.gerenciamento_pedidos.repositories;

import com.as.gerenciamento_pedidos.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
