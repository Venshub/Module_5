package com.log;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware{  
private String email,pass;  
SessionMap<String,Object> sessionmap;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}

public void setSession(Map<String, Object> map) {  
    this.sessionmap=(SessionMap<String, Object>)map;  
}

@Override
public String execute(){
	
	if(email != null) {
		LoginDao dao = new LoginDao();
		boolean check = dao.validate(email, pass);
		
		if(check == true){}
		
		else {
			String error = "Your email or password is incorrect!";
			return "error";
		}
		sessionmap.put("login","true");  
		sessionmap.put("email",email);  
	}
	return "success";
} 
  
public String logout(){  
    sessionmap.invalidate();  
    return "success";  
}  

}