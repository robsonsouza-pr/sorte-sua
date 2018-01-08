package br.com.innovate.sortesua.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.innovate.sortesua.infra.FileSaver;
import br.com.innovate.sortesua.models.Loteria;
import br.com.innovate.sortesua.repositories.LoteriaRepository;
import br.com.innovate.sortesua.validation.LoteriaValidator;

@Controller
@RequestMapping("/loterias")
public class LoteriasController {
	
	@Autowired
	private LoteriaRepository loteriaRepository;
	
	@Autowired
	private FileSaver fileSaver;
	
	@RequestMapping("form")
	public ModelAndView form(Loteria loteria) {
		 ModelAndView modelAndView = new ModelAndView("/loterias/form");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="loteriasHome", allEntries=true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Loteria loteria, BindingResult result, RedirectAttributes redirectAttributes){
		
		 if (result.hasErrors()) {
	            return form(loteria);
	        }
		 
		 String path = fileSaver.write("arquivos-sumario", sumario);
		 loteria.setSumarioPath(path);
		
		loteriaRepository.gravar(loteria);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:/loterias");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
	    List<Loteria> loterias = loteriaRepository.listar();
	    ModelAndView modelAndView = new ModelAndView("/loterias/lista");
	    modelAndView.addObject("loterias", loterias);
	    return modelAndView;
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Long id){
	    ModelAndView modelAndView = new ModelAndView("/loterias/detalhes");
	    Loteria loteria = loteriaRepository.find(id);
	    modelAndView.addObject("loteria", loteria);
	    return modelAndView;
	}
	
	//necessário para validação do formulário
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
	        binder.addValidators(new LoteriaValidator());
	}
}
