package br.com.innovate.sortesua.repositories;

import org.springframework.stereotype.Repository;

import br.com.innovate.sortesua.models.Resultado;

@Repository
public class ResultadoRepository extends BaseRepository {

	public Resultado findResultadoByIdSorteio(Long idSorteio) {

		return getEntityManager().createQuery("select distinct(r) from Resultado r"
				+ " join fetch r.sorteio s "
				+ " join fetch r.dezenas dezenas"
				+ " where r.sorteio.id = :idSorteio", Resultado.class).setParameter("idSorteio", idSorteio)
				.getSingleResult();
	}

}
