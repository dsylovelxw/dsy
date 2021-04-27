package denglu.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;
import denglu.entity.EasybuyUser;
import denglu.service.user.impl.UserServiceImpl;

@WebServlet("/UserSerlvet")
public class UserSerlvet extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return UserSerlvet.class;
	}
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
public void allUserByUserid(HttpServletRequest request ,HttpServletResponse response)
{
	Integer id=Integer.valueOf(request.getParameter("userid"));
	
	 
	
	EasybuyUser easybuyUserLogin = new UserServiceImpl().allUserByUserid(id);
	
	PrintUtil.write(easybuyUserLogin, response);
 
}
/**
 * 
 * @return
 */
public ReturnResult isUname(HttpServletRequest request ,HttpServletResponse response) {
	ReturnResult Result=new ReturnResult();
	String uname=request.getParameter("uname");
	System.out.println("uname"+uname);
	boolean data=new UserServiceImpl().CountEasybuyUser(uname);
	Result.setData(data);
	return Result;
}
public ReturnResult updateUserByAdmin(HttpServletRequest request ,HttpServletResponse response) {
	ReturnResult Result=new ReturnResult();
	String id=request.getParameter("uid");
	String loginName=request.getParameter("name");
	String  password=request.getParameter("pass");
	String userName=request.getParameter("realName");
	String sex=request.getParameter("sex");
	String email=request.getParameter("email");
	String mobile=request.getParameter("phone");
	String type=request.getParameter("isStatus");
	
	
	String lodname=request.getParameter("role");
	
	EasybuyUser user=new EasybuyUser();
	user.setId(Integer.valueOf(id));
	user.setUserName(userName);
	user.setType(Integer.valueOf(type));
	user.setLoginName(loginName);
	user.setPassword(password);
	user.setSex(Integer.valueOf(sex));
	user.setMobile(mobile);
	user.setEmail(email);
 
	int count=new UserServiceImpl().updateUserByAdmin(user);
 
	Result.setData(count);
	return Result;
}
public ReturnResult addUser(HttpServletRequest request ,HttpServletResponse response) {
	ReturnResult Result=new ReturnResult();
	 
	String loginName=request.getParameter("name");
	String  password=request.getParameter("pass");
	String userName=request.getParameter("realName");
	String sex=request.getParameter("sex");
	String email=request.getParameter("email");
	String mobile=request.getParameter("phone");
	 
	
	
	String lodname=request.getParameter("role");
	EasybuyUser user=new EasybuyUser();
	 
	user.setUserName(userName);
	 
	user.setLoginName(loginName);
	user.setPassword(password);
	user.setSex(Integer.valueOf(sex));
	user.setMobile(mobile);
	user.setEmail(email);
	int count=new UserServiceImpl().insertUser(user);
	Result.setData(count);
	return Result;
}
}
