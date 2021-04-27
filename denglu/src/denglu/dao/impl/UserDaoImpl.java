package denglu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

 
import com.utils.DataBaseUtil;
import com.utils.User_Denglu;

import denglu.dao.BaseDao;
import denglu.dao.UserDao;
import denglu.entity.EasybuyUser;

public class UserDaoImpl extends BaseDao implements UserDao {
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	public UserDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EasybuyUser allUserByUserid(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
	    ResultSet set=null;
	    EasybuyUser user=null;
	    Object [] parms= {id};
	    String sql="SELECT * FROM easybuy_user WHERE id=?";
	    set=super.excuteQuery(sql, parms);
	    try {
			while (set.next()) {
				
				 user=new EasybuyUser();
				 user.setId(set.getInt("id"));
				 user.setLoginName(set.getString("loginName"));
				 user.setUserName(set.getString("userName"));
				 user.setPassword(set.getString("password"));
				 user.setSex(set.getInt("sex"));
				 user.setIdentityCode(set.getString("identityCode"));
				 user.setEmail(set.getString("email"));
				 user.setMobile(set.getString("mobile"));
				 user.setType(set.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}finally {
			// 释放资源�?
			DataBaseUtil.closeAll(set, null, null);
		}
		return user;
	}

	@Override
	public int updateUserByAdmin(EasybuyUser user) {
		// TODO Auto-generated method stub
	    int count=0;
	    String sql="UPDATE  easybuy_user SET userName=?,PASSWORD=?,loginName=?,sex=?,email=?,mobile=?,TYPE=? WHERE id=?";
	    Object [] parms= {user.getUserName(),user.getPassword(),user.getLoginName(),user.getSex(),user.getEmail(),user.getMobile(),user.getType(),user.getId()};   
	    count=super.excuteUpdate(sql, parms);
		return count;
	}
	@Override 
	/**
	 * 查询用户是否存在
	 * @param name
	 * @return
	 */
	public int CountEasybuyUser(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT  count(*)  FROM easybuy_user  WHERE loginName=? ";
		
		 
		ResultSet set=null;
		Object [] parms= {name};
		int count=0;
		set=super.excuteQuery(sql.toString(), parms);
		
		try {
			while (set.next()) {
			
				count=set.getInt(1);
			
		}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}finally {
			// 释放资源�?
			DataBaseUtil.closeAll(set, null, null);
		}
		System.out.println(count+"count");
         
		return count;
	}

	@Override
	public int InsertaddUser(EasybuyUser user) {
		// TODO Auto-generated method stub
		 int count=0;
		    String sql=" INSERT INTO   easybuy_user   (userName,PASSWORD,loginName,sex ,email,mobile) VALUES(?,?,?,?,?,? )";
		    Object [] parms= {user.getUserName(),user.getPassword(),user.getLoginName(),user.getSex(),user.getEmail(),user.getMobile() };   
		    count=super.excuteUpdate(sql, parms);
			return count;
	}

	@Override
	public int DeleteaddUser(int userid) {
		// TODO Auto-generated method stub
		 int count=0;
		    String sql=" Delete    FROM user_meun WHERE userid=?";
		    Object [] parms= { userid };   
		    count=super.excuteUpdate(sql, parms);
			return count;
	}

	@Override
	public int InsertaddUser(int userid,int mentid) {
		// TODO Auto-generated method stub
		 int count=0;
		    String sql="  INSERT INTO   user_meun  (userid,meunid) VALUES(?,?)";
		    Object [] parms= {userid,mentid};   
		    count=super.excuteUpdate(sql, parms);
			return count;
	}

}
