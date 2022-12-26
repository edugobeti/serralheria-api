package com.edugobeti.serralheria.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.dto.ClienteDTO;
import com.edugobeti.serralheria.repository.ClienteRepository;
import com.edugobeti.serralheria.service.exception.DataIntegrityException;
import com.edugobeti.serralheria.service.exception.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

	private ClienteRepository repo;
	
	@Transactional(readOnly = true)
	public ClienteDTO buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return new ClienteDTO(obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado")));
	}
	
	@Transactional(readOnly = true)
	public List<ClienteDTO> listar(){
		List<Cliente> list = repo.findAll(); 
		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList()) ;
	}
	
	@Transactional
	public void salvar(ClienteDTO clienteDTO) {
		Cliente cliente = deDTO(clienteDTO);
		repo.save(cliente);
	}
	
	@Transactional
	public ClienteDTO atualizar(ClienteDTO clienteDTO) {
		Cliente cli = repo.findById(clienteDTO.getId()).get();
		if(cli.getId() == clienteDTO.getId()) {
			cli = deDTO(clienteDTO);
			repo.save(cli);
		}	
		return new ClienteDTO(cli);
	}
	
	public void deletar(Integer id) {
		buscar(id);
		try{
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cliente com pedidos associados não pode ser excluído");
		}
		
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
