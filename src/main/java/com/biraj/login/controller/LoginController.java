package com.biraj.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biraj.login.model.User;
import com.biraj.login.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository repo; 
	
	@PostMapping(path="/register")
	public @ResponseBody String register(@RequestBody User user){
		this.repo.save(user);
		return "sucessfully registered";
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
		  
		  //check login details with the saved user, if user is in databank show o
		  return "login success";
	  }

}
