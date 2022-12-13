package com.edugobeti.serralheria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.repository.PedidoRepository;
import com.edugobeti.serralheria.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = repo.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado"));
	}
	
	public List<Pedido> listar(){
		List<Pedido> list = repo.findAll();
		return list;
	}
}
