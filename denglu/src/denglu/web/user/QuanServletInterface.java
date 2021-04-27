package denglu.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import denglu.entity.Denglu;
import denglu.entity.User;
import denglu.service.user.impl.MenuServiceImpl;

import com.utils.MenudtreeData;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

@WebServlet("/QuanServletInterface")
public class QuanServletInterface  extends AbstractServlet{

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return QuanServletInterface.class;
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	 
			  doPost(request, response);	 
	}
public void allMenuDtree(HttpServletRequest request,HttpServletResponse response) {
	User<MenudtreeData> menu = new MenuServiceImpl().dtreeJson();
	PrintUtil.write(menu, response);
}
public void menuByUseridType1(HttpServletRequest request,HttpServletResponse response) {
	String id=request.getParameter("userid");
	
	 List<Denglu> menu = new MenuServiceImpl().DengluUserID(Integer.valueOf(id));
	 System.out.println("menu"+menu+"id"+id);
	PrintUtil.write(menu, response);
}
}
