package securityproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String Home()
	{
		return "Home";
	}
	
	@GetMapping("/login")
	public String Login()
	{
		return "Login";
	}
	
	@GetMapping("/register")
	public String Register()
	{
		return "Register";
	}
	

	@GetMapping("/main")
	public String Main() {
	    return "Main"; // This will map to Main.html in your templates folder
	}

	
	
}
