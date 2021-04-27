package denglu.dao;

import java.util.List;

import com.utils.Butn;

import denglu.entity.Denglu;
import denglu.entity.EasybuyUser;
import denglu.entity.Juese;

 

public interface QuanDao {
	//权限三级查询
	public  List<Denglu> QuanxianFind(int id);
	//权限查询
	List<Denglu> DengluUser(int id);
	//权限个数查询
	public int CountDengluUser();
	//登录用户信息查询
	public EasybuyUser DengluYong(String name);
	//用户总个数查询
	public int CountEasybuyUser();
	//用户所有信息查询
	public  List<EasybuyUser> EasybuyUserList(String name);
	//角色的个数
	public int CountJuese();
	//用户所扮演的角色
	public List<Juese>  JueseList(int id);
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
	//根据用户Id查询权限信息
	public  List<Denglu> DengluUserID(int id);
	
	public List<Butn> ButnFan(int id);
	 
}
