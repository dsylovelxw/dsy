package denglu.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

import denglu.entity.Juese;
import denglu.service.user.impl.LodeServiceImpl;

@WebServlet("/LodeSerlvet")
public class LodeSerlvet extends AbstractServlet {

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return LodeSerlvet.class;
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
	   
		super.doPost(request,response); 
	}
	public void allRole(HttpServletRequest request,HttpServletResponse response) {
		ReturnResult result = new ReturnResult();
		List<Juese> list = new LodeServiceImpl().JueseList(0);
	 PrintUtil.write(list, response);
		 
	}
	public  ReturnResult allRoleUserid(HttpServletRequest request,HttpServletResponse response)
	{
		String  id=request.getParameter("userid");
		ReturnResult result = new ReturnResult();
		Juese data=new LodeServiceImpl().Juese(Integer.valueOf(id));
		result.setData(data);
		return  result;
	}
	public ReturnResult queryUserIsRole(HttpServletRequest request,HttpServletResponse response)
	{
		String  id=request.getParameter("userid");
		ReturnResult result = new ReturnResult();
		Boolean b=new LodeServiceImpl().JueseCount(Integer.valueOf(id));
		int count=0;
		if(b==true) {
			count=1;
		}else{
			count=0;
		}
		
		result.setData(count);
		return result;
	}

}
