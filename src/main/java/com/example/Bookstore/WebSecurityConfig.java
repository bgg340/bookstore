package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Bookstore.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/css/**", "/signup", "/saveuser").permitAll()
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/booklist", true) 
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
	
	
	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	@Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
		}
	
	
	
}
