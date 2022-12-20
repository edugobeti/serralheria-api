package com.edugobeti.serralheria.domain.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.Endereco;
import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.domain.enuns.TipoCliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private String cpf_cnpj;
	
	private TipoCliente tipo;
	
	private Set<String> telefones = new HashSet<>();
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	private List<Pedido> pedidos = new ArrayList<>();

	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		email = cliente.getEmail();
		cpf_cnpj = cliente.getCpf_cnpj();
		tipo = cliente.getTipo();
		telefones.stream().map(tel -> cliente.getTelefones().add(tel)).collect(Collectors.toList());
		enderecos.stream().map(end -> cliente.getEnderecos().add(end)).collect(Collectors.toList());
		pedidos.stream().map(ped -> cliente.getPedidos().add(ped)).collect(Collectors.toList());
	}

}
