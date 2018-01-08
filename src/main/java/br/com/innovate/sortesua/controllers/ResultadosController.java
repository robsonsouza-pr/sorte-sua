package br.com.innovate.sortesua.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.innovate.sortesua.models.Dezena;
import br.com.innovate.sortesua.models.Resultado;
import br.com.innovate.sortesua.models.Sorteio;
import br.com.innovate.sortesua.repositories.DezenaRepository;
import br.com.innovate.sortesua.repositories.ResultadoRepository;
import br.com.innovate.sortesua.repositories.SorteioRepository;

@Controller
@RequestMapping("/resultados")
public class ResultadosController {
	
	@Autowired
	private SorteioRepository sorteioRepository;
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	@Autowired
	private DezenaRepository dezenaRepository;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView( "resultados/listarResultados");
		
		List<Sorteio> sorteios = sorteioRepository.listarSorteios();
		model.addObject("sorteios", sorteios);
		return model;
	}
	
	@RequestMapping(value="conferir/{idSorteio}", method=RequestMethod.GET)
	public ModelAndView conferir(@PathVariable("idSorteio") Long idSorteio){
		ModelAndView model = new ModelAndView( "resultados/conferirResultado");
		
		Resultado resultado = resultadoRepository.findResultadoByIdSorteio(idSorteio);
		
		List<Dezena> dezenasPossiveis = dezenaRepository.findDezenasPossiveisByQuantidadeDigitos(resultado.getSorteio().getTipo().getDigitos());
		model.addObject("dezenasPossiveis",dezenasPossiveis);
		model.addObject("resultado", resultado);
		return model;
	}
	
//	@RequestMapping( value="conferir/{idSorteio}",method=RequestMethod.POST)
//	public ModelAndView conferirResultado(@PathVariable("idSorteio") Long idSorteio, Resultado resultado){
//		ModelAndView model = new ModelAndView( "resultados/conferirResultado");
//		Resultado resultadoAntigo = resultadoRepository.findResultadoByIdSorteio(idSorteio);
//		model.addObject("resultado", resultadoAntigo);
//		return model;
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView form(Resultado resultado){
		return new ModelAndView("conferir/form");
	}	
}
