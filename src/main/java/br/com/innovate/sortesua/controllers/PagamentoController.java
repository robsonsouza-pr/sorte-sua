package br.com.innovate.sortesua.controllers;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.innovate.sortesua.models.CarrinhoAposta;
import br.com.innovate.sortesua.models.DadosPagamento;

@Controller
@RequestMapping("/pagamento")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

	@Autowired
	private CarrinhoAposta carrinho;

	@Autowired
	RestTemplate restTemplate;

	//Calable identifica um retorno assíncrono
	// por ser uma interface, é preciso retornar uma classe anônima identificada pelo return () -> {};
	@RequestMapping("/finalizarPedido")
	public Callable<ModelAndView> finalizarPedido(RedirectAttributes model) {
		return () -> {
			try {
				BigDecimal valor = new BigDecimal(carrinho.getQuantidade());
				DadosPagamento dados = new DadosPagamento(valor);
				String uri = "http://book-payment.herokuapp.com/payment";
				String response = restTemplate.postForObject(uri, dados, String.class);
				model.addFlashAttribute("sucesso", response);
				return new ModelAndView("redirect:/loterias");
			} catch (Exception e) {
				model.addFlashAttribute("sucesso", "Deu erro");
				return new ModelAndView("redirect:/loterias");
			}

		};
	}
}
