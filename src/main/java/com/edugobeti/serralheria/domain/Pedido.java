package com.edugobeti.serralheria.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private OffsetDateTime dataVenda;
	private OffsetDateTime dataInstalacao;
	private Double desconto;
	private Integer quantidade;
	private Double total;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco enderecoEntrega;
	
	@OneToMany(mappedBy = "pedido")
	private List<Portao> portoes = new ArrayList<>();

	public Pedido(Integer id, OffsetDateTime dataVenda, OffsetDateTime dataInstalacao, Double desconto,
			Integer quantidade, Double total, Cliente cliente, Pagamento pagamento, Endereco enderecoEntrega) {
		super();
		this.id = id;
		this.dataVenda = dataVenda;
		this.dataInstalacao = dataInstalacao;
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.total = total;
		this.cliente = cliente;
		this.pagamento = pagamento;
		this.enderecoEntrega = enderecoEntrega;
	}
	
	
}
