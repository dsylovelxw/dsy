package denglu.web.user;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import com.utils.Butn;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.utils.SecurityUtils;
import com.web.AbstractServlet;

import denglu.entity.Denglu;
import denglu.entity.EasybuyUser;
import denglu.entity.Juese;
import denglu.entity.User;
import denglu.service.user.impl.QuanServiceImpl;
@WebServlet("/QuanSerlvet")
public class QuanSerlvet extends AbstractServlet {

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return QuanSerlvet.class;
	}
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 查询用户按钮
	 * @param request
	 * @param response
	 * @return
	 */
	public String YonghuList(HttpServletRequest request ,HttpServletResponse response) {	 
		   String id=request.getParameter("id");
		   System.out.println(id);
		  List<Denglu> deeee=new QuanServiceImpl().QuanxianFind(Integer.valueOf(id));
		  request.setAttribute("deeee", deeee);
		  
		// 调用三层
		return "jsp/yonghu/xingxi";
	}
	/**
	 * 查询权限按钮
	 * @param request
	 * @param response
	 * @return
	 */
	public String QuanxianList(HttpServletRequest request ,HttpServletResponse response) {
		 String id=request.getParameter("id");
		   System.out.println(id);
	 
		  List<Denglu> deeee=new QuanServiceImpl().QuanxianFind(Integer.valueOf(id));
		  
		  request.setAttribute("deeee", deeee);
		return "jsp/yonghu/xingxi";
	}
	/**
	 * 查询角色按钮
	 * @param request
	 * @param response
	 * @return
	 */
	public String JueseList(HttpServletRequest request ,HttpServletResponse response) {
		 String id=request.getParameter("id");
		   System.out.println(id);
		  List<Denglu> deeee=new QuanServiceImpl().QuanxianFind(Integer.valueOf(id));
		  request.setAttribute("deeee", deeee);
		// 调用三层
		return "jsp/yonghu/xingxi";
	}
	/**
	 * 查询全部用户
	 * @param request
	 * @param response
	 */
	public  void  EasybuyUserList(HttpServletRequest request ,HttpServletResponse response) {	 
		       String LoginName=null;	 
              User<EasybuyUser> data=new  QuanServiceImpl().UserList(LoginName);           
	          PrintUtil.write(data, response);
	}
	/**
	 * 查询全部权限
	 * @param request
	 * @param response
	 */
	
	
	public  void  QuanUserList(HttpServletRequest request ,HttpServletResponse response) {	 
		      User<Denglu> data= new User<Denglu>();
		      data = new QuanServiceImpl().DengluList(0);
	          PrintUtil.write(data, response);
	}
	public ReturnResult isMenuName(HttpServletRequest request ,HttpServletResponse response) {
		String mname=request.getParameter("mname");
		ReturnResult result=new ReturnResult();
		
		return result;
	}
	/**
	 * 新增权限信息
	 * @param request
	 * @param response
	 * @return
	 */
	public void addMenu(HttpServletRequest request ,HttpServletResponse response) {
		String mname=request.getParameter("mname");
		String mfunction=request.getParameter("mfunction");
		String type2=request.getParameter("type2");
		String icon=request.getParameter("icon");
		String mbtn=request.getParameter("mbtn");
		String father=request.getParameter("father");
	 int count=0;
		 
		
		Denglu deng=new Denglu();
		deng.setmName(mname);
		deng.setType(Integer.valueOf(type2));
		 deng.setFatherid(Integer.valueOf(father));
		 deng.setMben(mbtn);
		count =new QuanServiceImpl().addDenglu(deng);
		PrintUtil.write(count, response);
	}
	public void 	allButtenType(HttpServletRequest request ,HttpServletResponse response) {
		 
		List<Butn> bt=new ArrayList<Butn>();
		bt=new QuanServiceImpl().ButnFan(0);
		 
		 PrintUtil.write(bt, response);
	}
	/**
	 *  查询全部角色
	 * @param request
	 * @param response
	 */
	public  void  JueseUserList(HttpServletRequest request ,HttpServletResponse response) {
		      User<Juese> data= new User<Juese>();
	          data = new QuanServiceImpl().JueseList(0);
              PrintUtil.write(data, response);
	}
	public ReturnResult menuByUserid(HttpServletRequest request ,HttpServletResponse response) {
		int id=Integer.valueOf(request.getParameter("userid"));
		String[] menuidList = request.getParameterValues("array");
		System.out.println("menuidList"+menuidList);
		ReturnResult result = new ReturnResult();
		int row = new  QuanServiceImpl().grantMenuByUserid(id, menuidList);
		if(row != 0 ) {
			result.returnSuccess("分配权限成功");
		}
		return result;
	}
 
	public ReturnResult DengluYan(HttpServletRequest request ,HttpServletResponse response) {
		String loginName=request.getParameter("name");
		String password=SecurityUtils.md5Hex(request.getParameter("pwd"));
		ReturnResult result=new ReturnResult();
		EasybuyUser user= new QuanServiceImpl().getEasybuyUserInfo(loginName);
	
		if (user == null) {
			// 判断该用户是否注册！！
			return result.returnFail("用户不存在");
		} else {
			// 注册了判断用户是否输入正确密码！
			if (user.getLoginName().equals(loginName) && user.getPassword().equals(password)) {
				// 登陆成功！账号密码匹配！！
				List<Denglu> de=new QuanServiceImpl().dengluUser(user.getId());
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("de", de);
				return result.returnSuccess("登陆成功");
			} else {
				return result.returnFail("输入的用户名或密码错误");
			}
		
		}
	 
		}
}
