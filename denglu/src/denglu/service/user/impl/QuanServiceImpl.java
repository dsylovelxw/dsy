package denglu.service.user.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.utils.Butn;
import com.utils.DataBaseUtil;

import denglu.dao.BaseDao;
import denglu.dao.impl.QuanDaoImpl;
import denglu.dao.impl.UserDaoImpl;
import denglu.entity.Denglu;
import denglu.entity.EasybuyUser;
import denglu.entity.Juese;
import denglu.entity.User;
import denglu.service.use.QuanService;

public class QuanServiceImpl implements QuanService{

	/**
	 * 使用Logger记录日志�?
	 */
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	@Override
	/**
	 * 根据用户名和密码查询相应信息业务！
	 */
	public EasybuyUser getEasybuyUserInfo(String loginName) {
		// 获得连接对象！
		Connection conn = null;
		EasybuyUser easybuyUserLogin = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			easybuyUserLogin = new  QuanDaoImpl(conn).DengluYong(loginName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return easybuyUserLogin;
	}

	
	
	@Override
	public List<Denglu> dengluUser(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Denglu> set = new ArrayList<Denglu>();
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
		 	set = new QuanDaoImpl(conn).DengluUser(id);
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		return set;
	}
	@Override
	public List<Denglu> QuanxianFind(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Denglu> dengt = new ArrayList<Denglu>();
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			dengt = new QuanDaoImpl(conn).QuanxianFind(id);
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		return dengt;
	}



	@Override
	public  User<EasybuyUser> UserList(String LoginName) {
		// TODO Auto-generated method stub
		 User<EasybuyUser> user=new  User<EasybuyUser>();
		Connection conn = null;
		 List<EasybuyUser> data=null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			count=new QuanDaoImpl(conn).CountEasybuyUser();
			data=new QuanDaoImpl(conn).EasybuyUserList(LoginName);		
		}  catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		 user.setCode(0);
		 user.setMsg("");
		 user.setCount(count);
		 user.setData(data);	
		return user;
	}
	@Override
	public User<Juese> JueseList(int id) {
		// TODO Auto-generated method stub
		User<Juese> juese=new User<Juese>();
		List<Juese> data=new ArrayList<Juese>();
		int count=0;
		Connection conn = null;
		
		try {
		
		conn = DataBaseUtil.getConnection();
		count= new QuanDaoImpl(conn).CountJuese();
		data=new QuanDaoImpl(conn).JueseList(id);
	}  catch (Exception e) {
		// 捕获异常�?
		logger.error(e.getMessage());
	} finally {
		// 释放资源�?
		DataBaseUtil.closeAll(null, null, conn);
	}
		juese.setCode(0);
		juese.setMsg("");
		juese.setCount(count);
		juese.setData(data);	
		return juese;
	}



	@Override
	public User<Denglu> DengluList(int id) {
		// TODO Auto-generated method stub
		User<Denglu> juese=new User<Denglu>();
				Connection conn = null;
				int count=0;
				List<Denglu> data = new ArrayList<Denglu>();
				try {
					// 获取连接对象�?
					conn = DataBaseUtil.getConnection();
					// 调用更新方法�?
					count=new QuanDaoImpl(conn).CountDengluUser();
				 	data = new QuanDaoImpl(conn).DengluUser(id);
				} catch (Exception e) {
					// 捕获异常�?
					logger.error(e.getMessage());
				} finally {
					// 释放资源�?
					DataBaseUtil.closeAll(null, null, conn);
				}
				juese.setCode(0);
				juese.setMsg("");
				juese.setCount(count);
				juese.setData(data);	
				return juese;
	}



	@Override
	public int QuanxianCount(String name) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int isMenuUrl(String mbtn) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int addDenglu(Denglu deng) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			// 调用更新方法�?
			count = new QuanDaoImpl(conn).addDenglu(deng);
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}



	@Override
	public int UpdateDenglu(Denglu deng) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int DeleteDenglu(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Butn> ButnFan(int id) {
		// TODO Auto-generated method stub
				 
				List<Butn> data=new ArrayList<Butn>();
			 
				Connection conn = null;
				
				try {
				
				conn = DataBaseUtil.getConnection();
				 
				data=new QuanDaoImpl(conn).ButnFan(id);
			}  catch (Exception e) {
				// 捕获异常�?
				logger.error(e.getMessage());
			} finally {
				// 释放资源�?
				DataBaseUtil.closeAll(null, null, conn);
			}
				 
				return data;
	}



	@Override
	public int grantMenuByUserid(int id, String[] ee) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 int count=0;
		 
		try {
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
			int o=new UserDaoImpl(conn).DeleteaddUser(id);
		 
			// 调用更新方法�?
			for (int i = 0; i < ee.length; i++) {
				
				count+= new  UserDaoImpl(conn).InsertaddUser(id,Integer.valueOf(ee[i]));
			}
			
		} catch (Exception e) {
			// 捕获异常�?
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(null, null, conn);
		}
		 
		return count;
		 
	}
}
