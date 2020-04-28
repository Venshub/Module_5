package com.regi;
import com.bean.EmpBean;
import com.dao.CandidateDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class UpdateAction extends ActionSupport {
	
	private static final long serialVersionUID = -3167883129536737843L;
	ResultSet rs = null;
	EmpBean bean = new EmpBean();
	String msg = null;
	
	public EmpBean getBean() {
		return bean;
	}

	public void setBean(EmpBean bean) {
		this.bean = bean;
	}

	@Override
	
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(false);

		if (session == null || session.getAttribute("login") == null) {
			return "fail";

		}

		else {
			String email = (String) session.getAttribute("email");
			CandidateDao dao = new CandidateDao();
				int i = dao.updateUserDetails(bean, email);
				if (i > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}
			return "REPORT";
		}
}
