package br.com.innovate.sortesua.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	//carrega as classes de configuração logo no start do tomcat
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{SecurityConfiguration.class, AppWebConfiguration.class, JpaConfiguration.class};
	}

	// carrega as classes de configuração quando necessárias
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String[] {"/"};
	}
	
	    @Override
	    protected Filter[] getServletFilters() {
	        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	        encodingFilter.setEncoding("UTF-8");
	        return new Filter[] {encodingFilter};
	    }
	    
	    @Override
	    protected void customizeRegistration(Dynamic registration) {
	        registration.setMultipartConfig(new MultipartConfigElement(""));
	    }
}
