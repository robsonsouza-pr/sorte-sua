package br.com.innovate.sortesua.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ApostaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tipoId;	
	
	private List<Long> dezenas = new ArrayList<>();
	
	public ApostaDto(){
		dezenas = new ArrayList<>();
	}


	public List<Long> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Long> dezenas) {
		this.dezenas = dezenas;
	}

	public Long getTipoId() {
		return tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}
}
