package denglu.service.use;

import java.util.List;

import com.utils.Butn;

import denglu.entity.Denglu;
import denglu.entity.EasybuyUser;
import denglu.entity.Juese;
import denglu.entity.User;
 

 

public interface QuanService {
	    //权限三级查询
	    public  List<Denglu> QuanxianFind(int id);
	    //用户权限查询
	    public List<Denglu>   dengluUser(int id);
	    //登录用户信息查询
	    public EasybuyUser getEasybuyUserInfo(String loginName);
	    //用户所有信息查询
	    public  User<EasybuyUser> UserList(String LoginName);
	     //用户所有权限查询 
	    public User<Denglu>  DengluList(int id);
		//用户所扮演的角色
		public User<Juese>  JueseList(int id);
		//查询用户新增权限名是否重复
		public int   QuanxianCount(String name);
		//  验证请求路径是否存在
		public int    isMenuUrl(String mbtn);
		//新增权限信息
		public int addDenglu(Denglu deng);
		//修改权限信息
		public int UpdateDenglu(Denglu deng);
		//删除权限信息
		public int DeleteDenglu(int id);
		
		public List<Butn> ButnFan(int id);
		public int grantMenuByUserid(int id,String[] ee);
	
}
