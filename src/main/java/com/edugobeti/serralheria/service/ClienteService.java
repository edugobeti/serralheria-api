package com.edugobeti.serralheria.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.dto.ClienteDTO;
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
	
	public List<Cliente> listar(){
		List<Cliente> list = repo.findAll(); 
		return list ;
	}
	
	public void salvar(Cliente cliente) {
		repo.save(cliente);
	}
	
	@Transactional
	public Cliente atualizar(ClienteDTO clienteDTO) {
		Cliente cli = repo.findById(clienteDTO.getId()).get();
		if(cli.getId() == clienteDTO.getId()) {
			cli = deDTO(clienteDTO);
			repo.save(cli);
		}	
		return cli;
	}
	
	private Cliente deDTO(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setId(dto.getId());
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setCpf_cnpj(dto.getCpf_cnpj());
		cliente.setTipo(dto.getTipo());
		cliente.setTelefones(dto.getTelefones());
		return cliente;
	}	
}
