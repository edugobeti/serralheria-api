package com.edugobeti.serralheria.domain.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.enuns.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	private Integer id;
	
	@NotBlank
	@Size(max = 50)
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String cpf_cnpj;
	
	private Set<String> telefones = new HashSet<>();
	
	@NotNull
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
