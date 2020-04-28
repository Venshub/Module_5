package com.regi;

import com.dao.CandidateDao;
import com.opensymphony.xwork2.ActionSupport;


public class DeleteAction extends ActionSupport {

	
	private static final long serialVersionUID = -3650233051333425192L;
	
	String email, msg;
	CandidateDao dao = new CandidateDao();
	
	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(email);
			if (isDeleted > 0) {
				msg = "The Profile is deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
