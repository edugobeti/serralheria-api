package com.edugobeti.serralheria;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.enuns.TipoCliente;
import com.edugobeti.serralheria.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Set<String> cli1Fones = new HashSet<>();
		cli1Fones.addAll(Arrays.asList("1934556920", "19993945845"));
		
		Set<String> cli2Fones = new HashSet<>();
		cli2Fones.addAll(Arrays.asList("1934631516", "19995635458"));
		
		Cliente cli1 = new Cliente(null, "Valeria Gonçalves", "valeria@gmail.com", "35654854522",TipoCliente.PESSOAFISICA, cli1Fones, null, null);
		Cliente cli2 = new Cliente(null, "Eduardo Silva", "eduardo@gmail.com", "35465986233", TipoCliente.PESSOAFISICA, cli2Fones, null, null);
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
	}



}
