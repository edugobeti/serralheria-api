package com.edugobeti.serralheria.domain.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.Endereco;
import com.edugobeti.serralheria.domain.Pagamento;
import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.domain.Portao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private OffsetDateTime dataVenda;
	private OffsetDateTime dataInstalacao;
	private Double desconto;
	private Integer quantidade;
	private Double total;
	
	private Cliente cliente;

	private Pagamento pagamento;
	
	private Endereco enderecoEntrega;

	private List<Portao> portoes = new ArrayList<>();
	
	public PedidoDTO(Pedido pedido) {
		id = pedido.getId();
		dataVenda = pedido.getDataVenda();
		dataInstalacao = pedido.getDataInstalacao();
		desconto = pedido.getDesconto();
		quantidade = pedido.getQuantidade();
		total = pedido.getTotal();
		cliente = pedido.getCliente();
		pagamento = pedido.getPagamento();
		enderecoEntrega = pedido.getEnderecoEntrega();
		portoes.stream().map(p -> pedido.getPortoes().add(p)).collect(Collectors.toList());
	}
}
