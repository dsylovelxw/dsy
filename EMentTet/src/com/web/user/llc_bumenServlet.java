package com.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceImpl.llc_ServiceImpl;
import com.entity.Lr_bumeng;


@WebServlet("/bumen")
public class llc_bumenServlet {
	/**
	 * 新增部门
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public int addbumrn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lr_bumeng men = new Lr_bumeng();
		men.setMeng_name(request.getParameter("name"));
		men.setRenshu_id(Integer.parseInt(request.getParameter("shu")));
		men.setUserId(Integer.parseInt(request.getParameter("userid")));
		int isYes = 0; // 返回信息
		int row = new llc_ServiceImpl().addbumen(men);
		if (row > 0) { // 判断用户是否增加成功
			// 根据用户登录名查询用户的信息
			isYes = 1;
		}
		return isYes;
	}
	/**
	 * 删除部门
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public int delbumrn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		int isYes = 0; // 返回信息
		int row = new llc_ServiceImpl().delbumen(id);
		if (row > 0) { // 判断用户是否增加成功
			// 根据用户登录名查询用户的信息
			isYes = 1;
		}
		return isYes;
	}
}
