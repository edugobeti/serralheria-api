package com.edugobeti.serralheria.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
public class PortaoSocial {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	private Integer modelo;
	private Double altura;
	private Double largura;
}
