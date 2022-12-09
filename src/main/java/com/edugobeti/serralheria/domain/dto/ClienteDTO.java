package com.edugobeti.serralheria.domain.dto;

import java.util.HashSet;
import java.util.Set;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.enuns.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private String cpf_cnpj;
	
	private Set<String> telefones = new HashSet<>();
	
	private TipoCliente tipo;
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		email = cliente.getEmail();
		cpf_cnpj = cliente.getCpf_cnpj();
		for(String fone : telefones) {
			telefones.add(fone);
		}
		
	}

}
