package com.regi;
import javax.mail.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.internet.*;

import com.dao.CandidateDao;
import com.opensymphony.xwork2.ActionSupport;
public class ForgotMail extends ActionSupport {

	private static final long serialVersionUID = -4576313426949936147L;

	 private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
    public String execute() throws Exception {
    	CandidateDao lol = new CandidateDao();
    	RegiAction bean = null;
        ResultSet rs = lol.report(email);
        while(rs.next()) {
        bean = new RegiAction();
        bean.setPass(rs.getString("pass"));
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
            message.setText("Dear User, We have received your request, Your password:" + bean.getPass());
            Transport.send(message);
            System.out.println("message sent to " + getEmail());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        }
        return "success";
    }
}
	
	

