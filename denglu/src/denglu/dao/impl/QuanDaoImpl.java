package denglu.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.utils.Butn;
import com.utils.DataBaseUtil;
import denglu.dao.BaseDao;
import denglu.dao.QuanDao;
import denglu.entity.Denglu;
import denglu.entity.EasybuyUser;
import denglu.entity.Juese;
public class QuanDaoImpl extends BaseDao  implements QuanDao{
	/**
	 * 使用Logger记录日志�?
	 */
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	public QuanDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Denglu> QuanxianFind(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM lr_meun WHERE  fatherid=? AND TYPE=3";
		Object [] parms= {id};
		ResultSet set=null;
		List<Denglu>  deng=new ArrayList<Denglu>();
		try {
			set=super.excuteQuery(sql, parms);
			while (set.next()) {
				Denglu	den = new Denglu();
				den.setId(set.getInt(1));
				den.setmName(set.getString(2));
				den.setFatherid(set.getInt(3));
				den.setMben(set.getString(4));
				den.setType(set.getInt(5));
				den.setIshide(set.getInt(6));
				den.setResUrl(set.getString(7));
				den.setJs(set.getString(8));
				deng.add(den);
			}		
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(set, null, null);
		}
		return deng;
	}
	@Override
	public List<Denglu> DengluUser(int id) {
		// TODO Auto-generated method stub
		// SQL语句�?
		// 创建数组为占位符赋�?�！			
		ResultSet set = null;
		// 声明用户信息对象�?
		List<Denglu> deng1=new ArrayList<Denglu>();
		
		StringBuilder  sql=new StringBuilder("SELECT * FROM lr_meun");
		if(id!=0 ) {
		 sql.append(" WHERE id IN (SELECT meunid FROM `user_meun` WHERE userid=?)");
		 Object[]  parms = {id};
		 set = super.excuteQuery(sql.toString(), parms);
		}else {
			set = super.excuteQuery(sql.toString(), null);
		}
				
				try {
					// 调用方法�?
					
					if (set != null) {
						while (set.next()) {
							Denglu	deng = new Denglu();
							deng.setId(set.getInt(1));
							deng.setmName(set.getString(2));
							deng.setFatherid(set.getInt(3));
							deng.setMben(set.getString(4));
							deng.setType(set.getInt(5));
							deng.setIshide(set.getInt(6));
							deng.setResUrl(set.getString(7));
							deng.setJs(set.getString(8));
							deng1.add(deng);
						}
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				} finally {
					// 释放资源�?
					DataBaseUtil.closeAll(set, null, null);
				}
				return deng1;
	}

	@Override
	public EasybuyUser DengluYong(String loginName) {
		// TODO Auto-generated method stub

		String sql = "SELECT `id`,`loginName`,`userName`,`password`,`sex`,`identityCode`,`email`,`mobile`,`type` FROM easybuy_user WHERE loginName = ?";
         ResultSet set=null;
         Object [] parms= {loginName};
         set=super.excuteQuery(sql, parms);
         EasybuyUser user=null;
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
	public int CountEasybuyUser() {
		// TODO Auto-generated method stub
		String sql="SELECT  count(*)  FROM easybuy_user  ";
		ResultSet set=null;
		Object [] parms=null;
		int count=0;
		set=super.excuteQuery(sql, parms);
		
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
         
		return count;
	}

	@Override
	public List<EasybuyUser> EasybuyUserList(String loginName) {
		// TODO Auto-generated method stub
		
		List<EasybuyUser>  list=new ArrayList<EasybuyUser>();
        ResultSet set=null;
		StringBuilder sql=new StringBuilder("SELECT `id`,`loginName`,`userName`,`password`,`sex`,`identityCode`,`email`,`mobile`,`type` FROM easybuy_user ");	
		
		if(loginName!=null){
			 sql.append("WHERE loginName = ?");	
			 Object [] parms= {loginName};
	         set=super.excuteQuery(sql.toString(), parms);
			
		}   else {
			 set=super.excuteQuery(sql.toString(), null);
		}         
		
           
         try {
			while (set.next()) {
				EasybuyUser  user=new EasybuyUser();
				 user.setId(set.getInt("id"));
				 user.setLoginName(set.getString("loginName"));
				 user.setUserName(set.getString("userName"));
				 user.setPassword(set.getString("password"));
				 user.setSex(set.getInt("sex"));
				 user.setIdentityCode(set.getString("identityCode"));
				 user.setEmail(set.getString("email"));
				 user.setMobile(set.getString("mobile"));
				 user.setType(set.getInt("type"));
				 list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}finally {
			// 释放资源�?
			DataBaseUtil.closeAll(set, null, null);
		}
         
         return list;
	}

	@Override
	public int CountDengluUser() {
		// TODO Auto-generated method stub
		 ResultSet set=null;
		 int count=0;
		 String sql="SELECT count(*) FROM lr_meun";
		 set=super.excuteQuery(sql, null);
		 try {
			while (set.next() ) {
				count=set.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); 
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 return count;
		 
	}
	@Override
	public int CountJuese() {
		// TODO Auto-generated method stub
		int count =0;
		ResultSet set=null;

		String sql="SELECT COUNT(*) FROM lr_lode";
		set=super.excuteQuery(sql, null);
		try {
			while (set.next()) {
				count=set.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
	return count;
	}
	@Override
	public List<Juese> JueseList(int id) {
		// TODO Auto-generated method stub
		List<Juese> juese=new ArrayList<Juese>();
		ResultSet set=null;
		StringBuilder sql=new StringBuilder("SELECT * FROM lr_lode");
		if(id!=0) {
			sql.append("WHERE id=1");
			Object [] parms= {id};
			set=super.excuteQuery(sql.toString(), parms);	
		}else {
			 
			set=super.excuteQuery(sql.toString(), null);
		}
		try {
			while (set.next()) {
				Juese ju=new Juese();
				ju.setId(set.getInt(1));
				ju.setLodName(set.getString(2));
				juese.add(ju);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		 logger.error(e.getMessage());
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return juese;
		
		
	}
	@Override
	public int QuanxianCount(String name) {
		// TODO Auto-generated method stub
		 
		 ResultSet set=null;
		 int count=0;
		 String sql="SELECT count(*) FROM lr_meun";
		 set=super.excuteQuery(sql, null);
		 try {
			while (set.next() ) {
				count=set.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); 
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 return count;
	}
	@Override
	public int isMenuUrl(String mbtn) {
		// TODO Auto-generated method stub
		 ResultSet set=null;
		 int count=0;
		 String sql="SELECT count(*) FROM lr_meun";
		 set=super.excuteQuery(sql, null);
		 try {
			while (set.next() ) {
				count=set.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); 
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 return count;
	}
	@Override
	public int addDenglu(Denglu deng) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO    lr_meun   (mName,fatherid,mbetn,TYPE) VALUES(?,?,?,?)";
		Object [] parms= {deng.getmName(),deng.getFatherid(),deng.getMben(),deng.getType() };
		int count =super.excuteUpdate(sql, parms);
		System.out.println(count+"count");
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
	public List<Denglu> DengluUserID(int id) {
		// TODO Auto-generated method stub
		 ResultSet set=null;
		 List<Denglu> deng=new ArrayList<Denglu>();
		 
		 Object [] parms= {id};
		 String sql=" SELECT  meunid FROM user_meun WHERE userid=?";
		 set=super.excuteQuery(sql, parms);
		 try {
			while (set.next() ) {
				Denglu deng1=new Denglu();
				 deng1.setId(set.getInt(1));
				deng.add(deng1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); 
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 System.out.println("deng"+deng);
		 return deng;
	}
	@Override
	public List<Butn> ButnFan(int id) {
		String sql="SELECT * FROM ls_butten";
		Object [] parms= {0};
		ResultSet set=null;
		List<Butn>  deng=new ArrayList<Butn>();
		try {
			set=super.excuteQuery(sql, null);
			while (set.next()) {
				Butn	den = new Butn();
				den.setId(set.getInt(1));
				 den.setBtntype(set.getString(2));
				deng.add(den);
			}		
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源�?
			DataBaseUtil.closeAll(set, null, null);
		}
		System.out.println("deng"+deng);
		return deng;
	}

}
