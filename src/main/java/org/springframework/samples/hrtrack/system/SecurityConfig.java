package org.springframework.samples.hrtrack.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.authorizeRequests().antMatchers("/employees/**", "/employees", "/employees.html")
				.access("hasRole('ROLE_ADMIN')").and().formLogin().and().logout().permitAll()
				.and().authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();*/
				http.authorizeRequests()
		        .antMatchers("/").permitAll()
		        .antMatchers("/h2-console/**").permitAll()
		        .antMatchers("/employees.html").access("hasRole('ROLE_ADMIN')")
		        .and().formLogin();
		
				http.csrf().disable();
				http.headers().frameOptions().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}password").roles("ADMIN");
	}

}