package com.as.gerenciamento_pedidos.services;

import com.as.gerenciamento_pedidos.models.PedidoModel;
import com.as.gerenciamento_pedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel criar(PedidoModel pedidoModel) {
        return pedidoRepository.save(pedidoModel);
    }

    public List<PedidoModel> listar() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> buscarId(Long id) {
        return  pedidoRepository.findById(id);
    }

    public PedidoModel atualizar(Long id, PedidoModel pedidoModel) {
        PedidoModel model = pedidoRepository.findById(id).get();
        model.setId(pedidoModel.getId());
        model.setData(pedidoModel.getData());
        model.setValorTotal(pedidoModel.getValorTotal());
        model.setStatus(pedidoModel.getStatus());
        return pedidoRepository.save(model);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
