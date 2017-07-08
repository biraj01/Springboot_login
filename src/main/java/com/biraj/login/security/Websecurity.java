package com.biraj.login.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Websecurity extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//authorize with username and password and with proper right(user or admin)
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password, 'true' as enabled from credients where username=?")
		.authoritiesByUsernameQuery("select username, role as authorities from credients where username=?");
				 
		//for in memory database. useful is there are not a lot of users to be registered
		//auth.inMemoryAuthentication().withUser("biraj").password("biraj").roles("USER");
		
	}
	
	@Override 
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/register").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
		.failureUrl("/login?error").permitAll().and().logout().permitAll();;
	}

}
