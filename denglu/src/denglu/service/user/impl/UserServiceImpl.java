package denglu.service.user.impl;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.utils.DataBaseUtil;

import denglu.dao.BaseDao;
 
import denglu.dao.impl.UserDaoImpl;
import denglu.entity.EasybuyUser;
import denglu.service.use.UserService;

public class UserServiceImpl implements UserService {
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	@Override
	public EasybuyUser allUserByUserid(int id) {
		
		Connection conn = null;
		EasybuyUser easybuyUserLogin = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			easybuyUserLogin = new  UserDaoImpl(conn).allUserByUserid(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return easybuyUserLogin;
	}

 
	@Override
	public boolean CountEasybuyUser(String name) {
		// TODO Auto-generated method stub
		 int count=0;
		 Connection conn = null;
		 try {
				conn = DataBaseUtil.getConnection();
				// 调用数据访问层代码！
				count = new  UserDaoImpl(conn).CountEasybuyUser(name);
				
			 
			} catch (Exception e) {
				logger.error(e.getMessage());
			} finally {
				// 释放资源！
				DataBaseUtil.closeAll(null, null, conn);
			}
			if(count>0) {
				return true;
				}else {
					return false;
				}
	}


	@Override
	public int updateUserByAdmin(EasybuyUser user) {
		// TODO Auto-generated method stub
		 int count=0;
		 Connection conn = null;
		 try {
				conn = DataBaseUtil.getConnection();
				// 调用数据访问层代码！
				count = new  UserDaoImpl(conn).updateUserByAdmin(user);
				
			 
			} catch (Exception e) {
				logger.error(e.getMessage());
			} finally {
				// 释放资源！
				DataBaseUtil.closeAll(null, null, conn);
			}
		 return count;
	}


	@Override
	public int insertUser(EasybuyUser user) {
		// TODO Auto-generated method stub
		 int count=0;
		 Connection conn = null;
		 try {
				conn = DataBaseUtil.getConnection();
				// 调用数据访问层代码！
				count = new  UserDaoImpl(conn).InsertaddUser(user);
				
			 
			} catch (Exception e) {
				logger.error(e.getMessage());
			} finally {
				// 释放资源！
				DataBaseUtil.closeAll(null, null, conn);
			}
		 return count;
	}
}
