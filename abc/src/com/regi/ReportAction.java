package com.regi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.EmpBean;
import com.dao.CandidateDao;
import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = -960522961243584919L;
	ResultSet rs = null;
	EmpBean bean = null;
	CandidateDao CandidateDao = new CandidateDao();
	private boolean noData = false;

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

		} else {
			String email = (String) session.getAttribute("email");
			rs = CandidateDao.report(email);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new EmpBean();
					bean.setFname(rs.getString("fname"));
					bean.setLname(rs.getString("lname"));
					bean.setUname(rs.getString("uname"));
					bean.setEmail(rs.getString("email"));
					bean.setPass(rs.getString("pass"));
					bean.setGender(rs.getString("gender"));
					bean.setPhone(rs.getString("phone"));
					bean.setAddress(rs.getString("address"));
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
			return "REPORT";
		}
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}
}
