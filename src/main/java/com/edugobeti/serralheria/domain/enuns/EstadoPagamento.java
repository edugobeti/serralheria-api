package com.edugobeti.serralheria.domain.enuns;

public enum EstadoPagamento {
	
	PENDENTE(1, "pendente"),
	QUITADO(2, "quitado"),
	CANCELADO(3, "cancelado");

	private int codigo;
	private String descricao;
	
	private EstadoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento paraEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
