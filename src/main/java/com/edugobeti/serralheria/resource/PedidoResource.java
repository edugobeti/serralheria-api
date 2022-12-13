package com.edugobeti.serralheria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	PedidoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPedido(@PathVariable Integer id){
		Pedido ped = service.buscar(id);
		return ResponseEntity.ok().body(ped);
	}
	
	@GetMapping
	public ResponseEntity<?> listarPedido(){
		List<Pedido> list = service.listar();
		return ResponseEntity.ok().body(list);
	}
}
