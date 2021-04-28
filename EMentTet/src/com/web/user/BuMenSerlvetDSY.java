package com.web.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.BuMenServiceImplDSY;
import com.utils.PrintUtil;
import com.web.AbstractServlet;

@WebServlet("/BuMenSerlvetDSY")
public class BuMenSerlvetDSY  extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return BuMenSerlvetDSY.class;
	}
public void isUname(HttpServletRequest request,HttpServletResponse response) {
	String uname=  request.getParameter("uname");
	int cout=new BuMenServiceImplDSY().NameLr_bumen(uname);
	PrintUtil.write(cout, response);
	
}
public void BuMenSerlve(HttpServletRequest request,HttpServletResponse response) {
	String uname=  request.getParameter("uname");
	int cout=new BuMenServiceImplDSY().NameLr_bumen(uname);
	PrintUtil.write(cout, response);
	
}
}
