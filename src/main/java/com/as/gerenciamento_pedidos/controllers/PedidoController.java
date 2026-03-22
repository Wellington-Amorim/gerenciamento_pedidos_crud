package com.as.gerenciamento_pedidos.controllers;

import com.as.gerenciamento_pedidos.models.PedidoModel;
import com.as.gerenciamento_pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> criar(@RequestBody PedidoModel pedidoModel) {
        PedidoModel pedido = pedidoService.criar(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pedido.getId())
                .toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listar() {
        List<PedidoModel> pedidos = pedidoService.listar();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> buscarId(@PathVariable Long id) {
        return pedidoService.buscarId(id);
    }

    @PutMapping("/{id}")
    public PedidoModel atualizar(@PathVariable Long id, @RequestBody PedidoModel pedidoModel) {
        return pedidoService.atualizar(id, pedidoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
