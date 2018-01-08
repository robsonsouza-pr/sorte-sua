package br.com.innovate.sortesua.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class DadosPagamento implements Serializable {

	private BigDecimal value;

	public DadosPagamento() {
	}

	public DadosPagamento(BigDecimal value) {
		super();
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
