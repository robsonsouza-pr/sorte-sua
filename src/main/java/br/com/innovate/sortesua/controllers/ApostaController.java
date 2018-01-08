package br.com.innovate.sortesua.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.innovate.sortesua.dtos.DezenaDto;
import br.com.innovate.sortesua.models.Aposta;
import br.com.innovate.sortesua.models.Dezena;
import br.com.innovate.sortesua.models.Resultado;
import br.com.innovate.sortesua.models.Sorteio;
import br.com.innovate.sortesua.repositories.ApostaRepository;
import br.com.innovate.sortesua.repositories.DezenaRepository;
import br.com.innovate.sortesua.repositories.ResultadoRepository;

@Controller
@RequestMapping("/apostas")
public class ApostaController {
		
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	@Autowired
	private DezenaRepository dezenaRepository;
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	@RequestMapping(value="apostar/{idSorteio}", method=RequestMethod.GET)
	public ModelAndView form(@PathVariable("idSorteio") Long idSorteio){
		ModelAndView modelAndView = new ModelAndView("apostas/form");
		
		Resultado resultado = resultadoRepository.findResultadoByIdSorteio(idSorteio);
		
		List<Dezena> listaDezenas = dezenaRepository.findDezenasPossiveisByQuantidadeDigitos(resultado.getSorteio().getTipo().getDigitos());
		List<DezenaDto> dezenasPossiveis = getDezenasPossiveis(listaDezenas);
		Aposta aposta = new Aposta();
		aposta.setTipoId(resultado.getSorteio().getId());
		modelAndView.addObject("aposta", aposta);
		modelAndView.addObject("dezenasPossiveis",dezenasPossiveis);
		return modelAndView;
	}
	
	private List<DezenaDto> getDezenasPossiveis(List<Dezena> listaDezenas) {
		List<DezenaDto> retorno = new ArrayList<>();
		listaDezenas.stream().forEach(item->retorno.add(new DezenaDto(item)));
		return retorno;
	}

	@RequestMapping( method=RequestMethod.POST)
	public ModelAndView gravar(@Valid  Aposta aposta, BindingResult result, RedirectAttributes redirectAttributes){
		
		ModelAndView model = new ModelAndView("redirec:/apostas");
		if(result.hasErrors()){
			return form(aposta.getTipo().getId());
		}
		
		popularListaDezenas(aposta);
		Sorteio sorteio = new Sorteio();
		sorteio.setId(aposta.getTipoId());
		aposta.setTipo(sorteio );
		
		apostaRepository.gravar(aposta);
		
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("apostas/listar");
		List<Aposta> apostas = apostaRepository.listar();
		model.addObject("apostas",apostas);
		return model;
	}

	private void popularListaDezenas(Aposta aposta) {
		aposta.getDezenasSelecionadas().stream().forEach(item-> aposta.getDezenas().add(new Dezena(item)));
		
	}
	
	
	
	//necessário para validação do formulário
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) {
//	        binder.addValidators(new ApostaValidator());
//	}

}
