package com.log;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.EmpBean;
import com.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class AdminReport extends ActionSupport {

	
	private static final long serialVersionUID = -3149689278908092423L;
	
	ResultSet rs = null;
	EmpBean bean = null;
	List<EmpBean> beanList = null;
	CandidateDao admin = new CandidateDao();
	private boolean noData = false;
	
	
	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<EmpBean>();
			rs = CandidateDao.admin();
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
					beanList.add(bean);
				}
	
				
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<EmpBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmpBean> beanList) {
		this.beanList = beanList;
	}

}
