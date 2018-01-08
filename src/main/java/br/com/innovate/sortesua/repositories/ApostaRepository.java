package br.com.innovate.sortesua.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.innovate.sortesua.models.Aposta;

@Repository
@Transactional
public class ApostaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void gravar(Aposta aposta){
		entityManager.persist(aposta);
	}

	public List<Aposta> listar() {
		return entityManager.createQuery("select distinct (a) from Aposta a join fetch a.tipo join fetch a.dezenas", Aposta.class).getResultList();
	}

}
