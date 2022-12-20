package com.edugobeti.serralheria.domain.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.edugobeti.serralheria.domain.Endereco;
import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.domain.Portao;
import com.edugobeti.serralheria.domain.enuns.EstadoPagamento;

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
	
	private Integer clienteId;

	private String estadoPagamento;
	
	private String formaPagamento;
	
	private Endereco enderecoEntrega;

	private List<Portao> portoes = new ArrayList<>();
	
	public PedidoDTO(Pedido pedido) {
		id = pedido.getId();
		dataVenda = pedido.getDataVenda();
		dataInstalacao = pedido.getDataInstalacao();
		desconto = pedido.getDesconto();
		quantidade = pedido.getQuantidade();
		total = pedido.getTotal();
		clienteId = pedido.getCliente().getId();
		estadoPagamento = pedido.getPagamento().getEstado().toString();
		formaPagamento = pedido.getPagamento().getForma().toString();
		enderecoEntrega = pedido.getEnderecoEntrega();
		portoes.stream().map(p -> pedido.getPortoes().add(p)).collect(Collectors.toList());
	}
}
