package br.com.innovate.sortesua.conf;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import br.com.innovate.sortesua.controllers.HomeController;
import br.com.innovate.sortesua.infra.FileSaver;
import br.com.innovate.sortesua.models.CarrinhoAposta;
import br.com.innovate.sortesua.repositories.LoteriaRepository;

/**
 *  A notação EnableWebMvc serve para que essa classe seja considerada um tipo de Filtro do SpringMVC
 * A notação ComponentScan está sendo usada para setar o pacote dos Controllers
 * herda WebMvcConfigurerAdapter para que possa fazê-la carregar os resources, no caso, bootstrap
 * @author Robson
 *
 */
@EnableWebMvc
@EnableCaching
@ComponentScan(basePackageClasses={HomeController.class, LoteriaRepository.class, FileSaver.class, CarrinhoAposta.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	//Define o prefixo e o sufixo das páginas no SpringMVC
	//Importante frisar que as páginas ficarão sempre dentro da pasta web-inf/views
	//a notação Bean é para indicar que o retorno do método é uma entidade gerenciada pelo Spring
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    //para permitir que o ben carrinho de apostas seja visivel nas jsp
	    resolver.setExposedContextBeanNames("carrinhoAposta");
	    
	    return resolver;
	}
	
	/** Método para carregar as mensagens de validação para o Spring
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource(){
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    //embora o endereço seja /WEB-INF/MESSAGES o arquivo deve ficar dentro do Web-Inf
	    messageSource.setBasename("/WEB-INF/messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(1);
	    return messageSource;
	}
	
	/**Para conversão de datas
	 * 
	 * @return
	 */
	@Bean
	public FormattingConversionService mvcConversionService(){
	    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
	    DateFormatterRegistrar formatterRegistrar = new DateFormatterRegistrar();
	    formatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
	    formatterRegistrar.registerFormatters(conversionService);

	    return conversionService;
	}
	
	//habilita o envio de arquivos multipart
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
    
    //Habilita o Spring a utilizar REST
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    //Habilita o Cache
    @Bean
    public CacheManager cacheManager(){
      CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(5, TimeUnit.MINUTES);
      GuavaCacheManager manager = new GuavaCacheManager();
      manager.setCacheBuilder(builder);
      return manager;
    }
    
    //habilita o carregamento de js e css
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
