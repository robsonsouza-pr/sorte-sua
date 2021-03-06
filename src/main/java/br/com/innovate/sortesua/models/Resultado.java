package br.com.innovate.sortesua.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Resultado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	private List<Dezena> dezenas = new ArrayList<>();
	
	@Transient
	private List<Dezena> dezenasSelecionadas = new ArrayList<>();
	
	@ManyToOne
	private Sorteio sorteio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Dezena> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Dezena> dezenas) {
		this.dezenas = dezenas;
	}

	public Sorteio getSorteio() {
		return sorteio;
	}

	public void setSorteio(Sorteio sorteio) {
		this.sorteio = sorteio;
	}
	
	public List<Dezena> getDezenasSelecionadas() {
		return dezenasSelecionadas;
	}

	public void setDezenasSelecionadas(List<Dezena> dezenasSelecionadas) {
		this.dezenasSelecionadas = dezenasSelecionadas;
	}

	public String getDezenasFormatadas(){
		StringBuilder dezenas = new StringBuilder();
		this.dezenas.sort((Dezena o1, Dezena o2)->o1.getId().intValue()-o2.getId().intValue());
		this.dezenas.stream().forEach(item->dezenas.append(item.getValor()+" - "));
		return dezenas.substring(0,dezenas.lastIndexOf("-")-1);
	}
}
