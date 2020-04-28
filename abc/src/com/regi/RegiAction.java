package com.regi;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dao.CandidateDao;
import com.opensymphony.xwork2.ActionSupport;

public class RegiAction extends ActionSupport{

	
	private static final long serialVersionUID = -6099414187193340080L;
	
	private String fname;
	private String lname;
	private String uname;
	private String gender;
	private String email;
	private String pass;
	private String phone;
	private String address;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String execute()throws Exception{ 
		int i= CandidateDao.register(this);  
		String to = getEmail();
	       Properties properties = new Properties();
	       properties.put("mail.smtp.host", "smtp.gmail.com");
	       properties.put("mail.smtp.socketFactory.port", "465");
	       properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	       properties.put("mail.smtp.auth", "true");
	       properties.put("mail.smtp.port", "465");

	       Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication("Abcjobs.pvt@gmail.com", "Lithan2020");
	           }
	       });
	       try {
	           MimeMessage message = new MimeMessage(session);
	           message.setFrom(new InternetAddress("Abcjobs.pvt@gmail.com"));
	           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	           message.setSubject("Abc Jobs Pvt");
	           message.setText("Welcome to Abc jobs pvt, you have successfully Registered and Good to Go...!!");
	           Transport.send(message);
	           System.out.println("message sent to " + getEmail());
	       }catch (MessagingException e) {
	           throw new RuntimeException(e);
	       }
	       
	       if(i > 0){  
	    	   return "success";  
	    }  
	       return "error";  
	}
	
	
	}
	
	

