package com.edugobeti.serralheria.domain.enuns;

public enum FormaPagamento {
	
	CARTOCREDITO(1, "credito"),
	BOLETO(2, "boleto"),
	DINHEIRO(3, "dinheiro");
	
	private int codigo;
	private String descricao;
	
	private FormaPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static FormaPagamento paraEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for (FormaPagamento x : FormaPagamento.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}

}
