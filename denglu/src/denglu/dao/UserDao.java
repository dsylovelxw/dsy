package denglu.dao;

 

import com.utils.User_Denglu;

import denglu.entity.EasybuyUser;

 
/**
 * 用户信息dao层
 * @author dsylovelxw
 *
 */
public interface UserDao {
	//根据用户id 查询用户信息
public  EasybuyUser  allUserByUserid(int  id);
// 修改用户信息
public int updateUserByAdmin(EasybuyUser user);
//查询用户是否存在
public int CountEasybuyUser(String name);
//新增用户信息
public int InsertaddUser(EasybuyUser user);
//
public int DeleteaddUser(int  userid);

public int InsertaddUser(int userid,int mentid);
}
