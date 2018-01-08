package br.com.innovate.sortesua.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.innovate.sortesua.models.Loteria;

@Repository
@Transactional
public class LoteriaRepository {

	@PersistenceContext
	EntityManager manager;

	public void gravar(Loteria loteria) {
		manager.persist(loteria);
	}

	public List<Loteria> listar() {
		return manager.createQuery("select l from Loteria l", Loteria.class).getResultList();
	}

	public Loteria find(Long id) {
		
		 return manager.createQuery("select l from Loteria l where l.id = :id", Loteria.class)
				 .setParameter("id",id).getSingleResult();
	}
}
