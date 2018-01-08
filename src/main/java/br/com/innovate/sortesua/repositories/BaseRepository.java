package br.com.innovate.sortesua.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class BaseRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager(){		
		return entityManager;
	}

}
