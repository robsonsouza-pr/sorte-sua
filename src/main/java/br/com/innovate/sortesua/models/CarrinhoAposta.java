package br.com.innovate.sortesua.models;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CarrinhoAposta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<Loteria, Integer> itens = new LinkedHashMap<Loteria, Integer>();
	
	public void add(Loteria item){
		Integer quantidade = getQuantidade(item);
		itens.put(item,quantidade+1);
	}

	public Integer getQuantidade(Loteria item) {
		
		return itens.containsKey(item) ? itens.get(item)  : 0;
	}
	
	public Integer getQuantidade(){
		return itens.values().stream().reduce(0,(proximo, acumulador)->(proximo+acumulador));
	}

}
