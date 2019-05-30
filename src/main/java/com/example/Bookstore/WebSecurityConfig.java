package com.example.Bookstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/css/**").permitAll()
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.authorizeRequests().antMatchers("/login*").permitAll()
		.and()
		.authorizeRequests().antMatchers("/signup*").permitAll()
		.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/booklist")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
	
	
	
	
	
	
}
