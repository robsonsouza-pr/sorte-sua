package br.com.innovate.sortesua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.innovate.sortesua.models.CarrinhoAposta;
import br.com.innovate.sortesua.models.Loteria;
import br.com.innovate.sortesua.repositories.LoteriaRepository;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {
	
	@Autowired
	private CarrinhoAposta carrinhoAposta;
	
	@Autowired
	private LoteriaRepository loteriaRepoitory;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(Long loteriaId){
		Loteria loteria = loteriaRepoitory.find(loteriaId);
		carrinhoAposta.add(loteria);
		return new ModelAndView("redirect:/loterias");
	}

}
