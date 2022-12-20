package com.edugobeti.serralheria.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugobeti.serralheria.domain.dto.PedidoDTO;
import com.edugobeti.serralheria.service.ClienteService;
import com.edugobeti.serralheria.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	PedidoService service;
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPedido(@PathVariable Integer id){
		PedidoDTO ped = service.buscar(id);
		return ResponseEntity.ok().body(ped);
	}
	
	@GetMapping
	public ResponseEntity<?> listarPedido(){
		List<PedidoDTO> list = service.listar();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/clientes/{id}")
	public ResponseEntity<?> listarPedidos(@PathVariable Integer id){
		clienteService.buscar(id);
		List<PedidoDTO> listPedido = new ArrayList<>();
		List<PedidoDTO> list = service.listar();
		for(PedidoDTO pedido : list) {
			if(pedido.getCliente().getId().equals(id)) {
				listPedido.add(pedido) ;
			}
		}
		return ResponseEntity.ok().body(listPedido);
	}
}
