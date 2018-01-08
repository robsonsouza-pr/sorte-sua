package br.com.innovate.sortesua.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Aposta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="tipo_id")
	private Sorteio tipo;
	
	@ManyToMany
	private List<Dezena> dezenas = new ArrayList<>();
	
	@Transient
	private List<Long> dezenasSelecionadas =new ArrayList<>();
	
	@Transient
	private Long tipoId;
	
	public Aposta(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Sorteio getTipo() {
		return tipo;
	}


	public void setTipo(Sorteio tipo) {
		this.tipo = tipo;
	}

	

	public List<Dezena> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Dezena> dezenas) {
		this.dezenas = dezenas;
	}
	
	public List<Long> getDezenasSelecionadas() {
		return dezenasSelecionadas;
	}

	public void setDezenasSelecionadas(List<Long> dezenasSelecionadas) {
		this.dezenasSelecionadas = dezenasSelecionadas;
	}
	
	public Long getTipoId() {
		return tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}
	
	public String getDezenasFormatadas(){
		StringBuilder dezenas = new StringBuilder();
		this.dezenas.sort((Dezena o1, Dezena o2)->o1.getId().intValue()-o2.getId().intValue());
		this.dezenas.stream().forEach(item->dezenas.append(item.getValor()+" - "));
		return dezenas.substring(0,dezenas.lastIndexOf("-")-1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
