package com.edugobeti.serralheria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.edugobeti.serralheria.domain.enuns.MedidaCaixaria;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Portao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	private Integer modelo;
	private Double largura;
	private Double altura;
	private Double folgaPiso;
	private Integer qtdMotores;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "portao_id")
	private List<Motor> motores = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "portao_id")
	private List<Trava> travas = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "portao_id")
	private List<PortaoSocial> portoesSocial = new ArrayList<>();
	
	@Enumerated
	private MedidaCaixaria caixa;
	
}
