package com.regi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.EmpBean;
import com.dao.CandidateDao;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	
	private static final long serialVersionUID = -4562220312005769836L;
	ResultSet rs = null;
	EmpBean bean = null;
	List<EmpBean> beanList = null;
	EmpBean search = null;
	private boolean noData = false;
	private String field;
	
	CandidateDao dao = new CandidateDao();
	
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
@Override
	public String execute() throws Exception {
		
			if(field!=null) {
				String find = field +"%";
			
			search = new EmpBean();
            beanList = new ArrayList<EmpBean>();
            rs = dao.search(find);
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
					i++;
					bean = new EmpBean();
					bean.setFname(rs.getString("fname"));
					bean.setLname(rs.getString("lname"));
					bean.setUname(rs.getString("uname"));
					bean.setEmail(rs.getString("email"));
					
					bean.setGender(rs.getString("gender"));
					
					
					beanList.add(bean);
				}
	
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
			}
		
		return "Report";
	}
	
}


