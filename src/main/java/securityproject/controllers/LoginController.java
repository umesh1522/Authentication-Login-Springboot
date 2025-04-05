//package securityproject.controllers;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class LoginController {
//	
//	@GetMapping("/forgotusername")
//	public String ForgotUsername()
//	{
//		return "ForgotUN";
//	}
//	
//	@GetMapping("/forgotpassword")
//	public String ForgotPassword()
//	{
//		return "ForgotPwd";
//	}
//	
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
////	String hardcodedusername = "abc@gmail.com";
////	String hardcodedpassword = "12345";
////	
//	@PostMapping("/loginsubmit")
//	@ResponseBody
//	public Map<String,String> OnLogin(@RequestBody Map<String,String> logindata)
//	{
//		Map<String,String> response = new HashMap<>();
//		String msg = "";
//		
//		String sql = "Select count(*) from user where username=? AND password=?";
//		Integer count = jdbcTemplate.queryForObject(sql, Integer.class,
//				logindata.get("username"), logindata.get("password"));
//		
////		if(logindata.get("username").equals(hardcodedusername) && 
////				logindata.get("password").equals(hardcodedpassword))
////		{
////			msg = "Sucessfully Login";
////		}
////		else
////		{
////			msg = "Incorrect username and password";
////		}
//		
//		
//		if(count>0 && count!=null)
//		{
//			msg = "Sucessfully Login";
//		}
//		else
//		{
//			msg = "Incorrect username and password";
//		}
//		
//		response.put("message", msg);
//		
//		return response;
//	}
//	
//	
//	@PostMapping("/createaccount")
//	@ResponseBody
//	
//	public Map<String,String> Onregister(@RequestBody Map<String,String> createaccount)
//	
//	{
//		
//		Map<String,String> response = new HashMap<>();
//		String msg ="";
//		
//		String sql = "insert into user(username,password,emailid) values(?,?,?)";
//		jdbcTemplate.update(sql,
//		createaccount.get("username"), createaccount.get("password"),createaccount.get("email"));
//		msg = "Successfully createaccount";
//		
//		response.put("message", msg);
//		return response;
//		
//	}
//	@PostMapping("/forgotpassincontroller")
//	@ResponseBody
//	
//	public Map<String,String> Onforgotpass(@RequestBody Map<String,String> forgotpass)
//	
//	{
//		
//		Map<String,String> response = new HashMap<>();
//		String msg ="";
//		
//		String sql = "update user set password= ? where emailid = ?";
//		jdbcTemplate.update(sql,
//		forgotpass.get("password"), forgotpass.get("email"));
//		msg = "Password change successfully";
//		
//		response.put("message", msg);
//		return response;
//		
//	}
//}





package securityproject.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/forgotusername")
    public String ForgotUsername() {
        return "ForgotUN";
    }
    
    @GetMapping("/forgotpassword")
    public String ForgotPassword() {
        return "ForgotPwd";
    }
    
    @PostMapping("/loginsubmit")
    @ResponseBody
    public Map<String, String> OnLogin(@RequestBody Map<String, String> logindata) {
        Map<String, String> response = new HashMap<>();
        String msg = "";
        
        String sql = "SELECT COUNT(*) FROM user WHERE username=? AND password=?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class,
                logindata.get("username"), logindata.get("password"));
        
        if (count != null && count > 0) {
            msg = "Successfully Logged In";
        } else {
            msg = "Incorrect username and password";
        }
        
        response.put("message", msg);
        return response;
    }
    
    @PostMapping("/createaccount")
    @ResponseBody
    public Map<String, String> OnRegister(@RequestBody Map<String, String> createAccount) {
        Map<String, String> response = new HashMap<>();
        
        String sql = "INSERT INTO user (username, password, emailid) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                createAccount.get("username"),
                createAccount.get("password"),
                createAccount.get("email"));
        
        response.put("message", "Successfully created account");
        return response;
    }
    
    @PostMapping("/forgotpassincontroller")
    @ResponseBody
    public Map<String, String> OnForgotPass(@RequestBody Map<String, String> forgotPass) {
        Map<String, String> response = new HashMap<>();
        
        String sql = "UPDATE user SET password=? WHERE emailid=?";
        jdbcTemplate.update(sql,
                forgotPass.get("password"),
                forgotPass.get("email"));
        
        response.put("message", "Password changed successfully");
        return response;
    }
    
    @PostMapping("/forgotusernamecontroller")
    @ResponseBody
    public Map<String, String> OnForgotUsername(@RequestBody Map<String, String> forgotUsername) {
        Map<String, String> response = new HashMap<>();
        
        String sql = "SELECT username FROM user WHERE emailid = ?";
        try {
            String username = jdbcTemplate.queryForObject(sql, String.class, forgotUsername.get("email"));
            response.put("message", "Your username is: " + username);
        } catch (Exception e) {
            response.put("message", "Email not found in our records.");
        }

        return response;
    }
    
    @PostMapping("/logout")
    @ResponseBody
    public Map<String, String> OnLogout(@RequestBody Map<String, String> logout) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Successfully logged out");
        return response;
    }
    
    
    

}


