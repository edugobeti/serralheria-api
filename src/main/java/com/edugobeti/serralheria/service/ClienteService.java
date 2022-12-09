package com.edugobeti.serralheria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.dto.ClienteDTO;
import com.edugobeti.serralheria.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

	private ClienteRepository repo;
	
	@Transactional(readOnly = true)
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> listar(){
		List<Cliente> list = repo.findAll(); 
		return list ;
	}
	
	@Transactional
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
	
	@Transactional
	public void deletar(Integer id) {
		repo.deleteById(id);
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
