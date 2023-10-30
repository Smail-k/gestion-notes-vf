package com.polytech.notes.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.polytech.notes.filter.CustomAuthenticationFilter;
import com.polytech.notes.filter.CustomAuthorizationFilter;

@Configuration @EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authenticationManagerBean());
		filter.setFilterProcessesUrl("/api/login");
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/login/**","/api/token/refresh/**","/ExcelImport.html","/ExcelImportEtudiants.html").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ExcelImportNote.html").permitAll();
 
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/login/**","/api/excel","/api/excel/etudiant","/api/excel/note").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/user").hasAuthority("ADMIN");
 		//http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/user").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		
		//http.authorizeRequests().anyRequest().permitAll();
		http.addFilter(filter);
		http.addFilterBefore(new CustomAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	}
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
}
