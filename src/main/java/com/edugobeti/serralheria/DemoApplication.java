package com.edugobeti.serralheria;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edugobeti.serralheria.domain.Cidade;
import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.Endereco;
import com.edugobeti.serralheria.domain.Estado;
import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.domain.enuns.TipoCliente;
import com.edugobeti.serralheria.repository.CidadeRepository;
import com.edugobeti.serralheria.repository.ClienteRepository;
import com.edugobeti.serralheria.repository.EnderecoRepository;
import com.edugobeti.serralheria.repository.EstadoRepository;
import com.edugobeti.serralheria.repository.PedidoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	ClienteRepository clienteRepo;
	
	PedidoRepository pedidoRepo;
	
	EnderecoRepository enderecoRepo;
	
	CidadeRepository cidadeRepo;
	
	EstadoRepository estadoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Set<String> cli1Fones = new HashSet<>();
		cli1Fones.addAll(Arrays.asList("1934556920", "19993945845"));
		Set<String> cli2Fones = new HashSet<>();
		cli2Fones.addAll(Arrays.asList("1934631516", "19995635458"));
		
		Cliente cli1 = new Cliente(null, "Valeria Gonçalves", "valeria@gmail.com", "35654854522",TipoCliente.PESSOAFISICA, cli1Fones,null, null);
		Cliente cli2 = new Cliente(null, "Eduardo Silva", "eduardo@gmail.com", "35465986233", TipoCliente.PESSOAFISICA, cli2Fones, null, null);
		
		Estado e1 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Sâo Paulo", e1);
		Cidade c2 = new Cidade(null, "Campinas", e1);
		
		Endereco enderecoEntrega1 = new Endereco(null, "AV Doze", "124", "Apt 12", "Centro", "13456-923", c1, cli1);
		Endereco enderecoEntrega2 = new Endereco(null, "AV XV de Novembro", "456", "loja 1", "Centro", "13456-456", c2, cli2);
		
		Pedido ped1 = new Pedido(null
				, OffsetDateTime.parse("2022-12-08T12:21:56Z")
				, OffsetDateTime.parse("2022-12-12T12:21:56Z")
				, 0.0, 1, 8990.0, cli1, null, enderecoEntrega2 );
		Pedido ped2 = new Pedido(null
				, OffsetDateTime.now()
				, OffsetDateTime.parse("2022-12-15T12:21:56Z")
				, 300.0, 1, 6990.0, cli2, null, enderecoEntrega1 );
		Pedido ped3 = new Pedido(null
				, OffsetDateTime.now()
				, OffsetDateTime.parse("2022-12-15T12:21:56Z")
				, 300.0, 1, 6990.0, cli2, null, enderecoEntrega1 );
		
		cli1.setEnderecos(Arrays.asList(enderecoEntrega1));
		cli1.setPedidos(Arrays.asList(ped1));
		cli2.setEnderecos(Arrays.asList(enderecoEntrega2));
		cli2.setPedidos(Arrays.asList(ped2, ped3));
		
		clienteRepo.saveAll(Arrays.asList(cli1, cli2));
		estadoRepo.save(e1);
		cidadeRepo.saveAll(Arrays.asList(c1, c2));
		enderecoRepo.saveAll(Arrays.asList(enderecoEntrega1, enderecoEntrega2));
		pedidoRepo.saveAll(Arrays.asList(ped1, ped2, ped3));

		
		
	}
}
