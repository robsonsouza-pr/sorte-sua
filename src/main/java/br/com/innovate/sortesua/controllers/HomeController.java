package br.com.innovate.sortesua.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.innovate.sortesua.models.Loteria;
import br.com.innovate.sortesua.repositories.LoteriaRepository;

@Controller
public class HomeController {
	
	@Autowired
	private LoteriaRepository loteriaRepository;
	
	@RequestMapping("/")
	@Cacheable(value="loteriasHome")
	public ModelAndView index(){
		List<Loteria> loterias = loteriaRepository.listar();
		ModelAndView model = new ModelAndView("home");
		model.addObject("loterias", loterias);
		return  model;
	}

}
