package com.edugobeti.serralheria.domain.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private OffsetDateTime dataVenda;
	private OffsetDateTime dataInstalacao;
	private Double desconto;
	private Integer qunatidade;
	private Double total;
}
