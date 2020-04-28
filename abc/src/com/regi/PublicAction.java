package com.regi;

import java.sql.ResultSet;

import com.bean.EmpBean;
import com.dao.CandidateDao;
import com.opensymphony.xwork2.ActionSupport;

public class PublicAction extends ActionSupport {

	private static final long serialVersionUID = -960522961243584919L;
	ResultSet rs = null;
	EmpBean bean = null;

	public EmpBean getBean() {
		return bean;
	}

	public void setBean(EmpBean bean) {
		this.bean = bean;
	}
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String execute() throws Exception {

			bean = CandidateDao.view(email);
			if (bean != null) {
				return "REPORT";
			}
			else {
				return "fail";
			}
			
			
		}
}
