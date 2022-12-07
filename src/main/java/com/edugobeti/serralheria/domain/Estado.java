 package com.edugobeti.serralheria.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

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
public class Estado {
	
	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	
	@NotBlank
	private String nome;

	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<>();
}
