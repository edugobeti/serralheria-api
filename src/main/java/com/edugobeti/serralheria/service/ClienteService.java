package com.edugobeti.serralheria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public void salvar(List<Cliente> listaCliente) {
		repo.saveAll(listaCliente);
	}
	
	public List<Cliente> listar(){
		List<Cliente> list = repo.findAll(); 
		return list ;
	}
}
