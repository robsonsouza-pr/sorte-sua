package br.com.innovate.sortesua.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.innovate.sortesua.models.Dezena;

@Repository
public class DezenaRepository extends BaseRepository {


	public List<Dezena> findDezenasPossiveisByQuantidadeDigitos(int digitos) {
		Long quantidade = new Long(digitos);
		return getEntityManager()
				.createQuery("select d from Dezena d where d.id <= :digitos order by d.id ", Dezena.class)
				.setParameter("digitos", quantidade).getResultList();
	}

}
