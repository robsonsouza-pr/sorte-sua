package br.com.innovate.sortesua.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.innovate.sortesua.models.Sorteio;

@Repository
@Transactional
public class SorteioRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Sorteio> listarSorteios(){
	return	manager.createQuery("select s from Sorteio s join fetch s.tipo ", Sorteio.class).getResultList();
	}
}
