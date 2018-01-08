package br.com.innovate.sortesua.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.innovate.sortesua.repositories.UsuarioRepository;

//Classe para configurar a segurança e os níveis de acesso do Spring, etc

@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    .antMatchers("/loterias/form").hasRole("ADMIN")
	    .antMatchers("/carrinho/**").permitAll()
	    .antMatchers("/resultados/**").permitAll()
	    .antMatchers("/apostas/**").permitAll()
	    .antMatchers(HttpMethod.POST, "/loterias").hasRole("ADMIN")
	    .antMatchers(HttpMethod.GET, "/loterias").hasRole("ADMIN")
	    .antMatchers("/loterias/**").permitAll()
	    .antMatchers("/resources/**").permitAll()
	    .antMatchers("/").permitAll()
	    .anyRequest().authenticated()
	    .and().formLogin().loginPage("/login").permitAll()
	    .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioRepository).passwordEncoder(new BCryptPasswordEncoder());
    }

}
