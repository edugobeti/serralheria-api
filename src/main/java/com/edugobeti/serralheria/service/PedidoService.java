package com.edugobeti.serralheria.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.domain.dto.PedidoDTO;
import com.edugobeti.serralheria.repository.PedidoRepository;
import com.edugobeti.serralheria.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	@Transactional(readOnly = true)
	public PedidoDTO buscar(Integer id) {
		Optional<Pedido> pedido = repo.findById(id);
		return new PedidoDTO(pedido.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado")));
	}
	
	@Transactional(readOnly = true)
	public List<PedidoDTO> listar(){
		List<Pedido> list = repo.findAll();
		return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
	}
}
