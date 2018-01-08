package br.com.innova.sortesua.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.innovate.sortesua.conf.JpaConfiguration;
import br.com.innovate.sortesua.models.Loteria;
import br.com.innovate.sortesua.repositories.LoteriaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class,LoteriaRepository.class})
public class LoteriaDaoTest {
	
	@Autowired
	private LoteriaRepository repository;
	
	@Test
    @Transactional
    public void testaMetodoListar() {
		List<Loteria> loterias = repository.listar();
		
		Assert.notNull(loterias);
	}

}

