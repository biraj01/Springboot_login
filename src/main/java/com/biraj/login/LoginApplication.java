package com.biraj.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.biraj.login.validator.PasswordValidator;

@SpringBootApplication
public class LoginApplication {

	
	
	//Define a passwordvalidator bean here or just define the password validator class as a component
	/*@Bean
	public PasswordValidator passwordVaildator(){
		return new PasswordValidator();
	}*/
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
}
