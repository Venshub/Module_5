package com.log;

public class AdminAction {

	private String adminid;
	private String password;
	
	
	public String execute() {
		
		if(getAdminid().equals("venson.dsouza@yahoo.com") && getPassword().equals("123456")) {
			return "success";
		}else {
		return "error";}
	}
	
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
