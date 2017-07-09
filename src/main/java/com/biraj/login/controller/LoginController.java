package com.biraj.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biraj.login.model.User;
import com.biraj.login.repository.UserRepository;
import com.biraj.login.validator.PasswordValidator;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository repo; 
	
	@GetMapping(path="/register")
	public String newRegister(Model model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping(path="/register")
	public  String register(@ModelAttribute  @Valid User user,BindingResult bindingResult){
		validator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("not vaild");
            return "register";
        }
		System.out.println("is vaild");

		this.repo.save(user);
		return "/";
	}
	
	
	/*@PostMapping(path="/login")
	public @ResponseBody String login(@RequestBody User user){	
		return "sucessfully logged in";
	}*/
	
	@GetMapping(path="/login")
	  public String login(Model model){
		  model.addAttribute("user", new User());
	   return "login"; 
	  }
	  
	  @PostMapping(path="/login")
	  public @ResponseBody String checklogin(@ModelAttribute User user){	  
		  return "redirect:/register";
	  }
	  
	  @GetMapping(path="/")
	  public @ResponseBody String home(){
		 
	   return "welcome to dashboard"; 
	  }
	  
	  
	  @Autowired
	  private PasswordValidator validator;
	 
}
