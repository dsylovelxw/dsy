package denglu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.utils.DataBaseUtil;

import denglu.dao.BaseDao;
import denglu.dao.LodeDao;
import denglu.entity.Juese;
public class LodeDaoImpl extends BaseDao implements LodeDao {
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	public LodeDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
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
	public  Juese Juese(int id) {
		// TODO Auto-generated method stub
		Juese ju=new Juese();
		ResultSet set=null;
		Object[] parms={id};
		String sql="SELECT    * FROM  lr_lode WHERE id = (SELECT lodeid FROM user_lode WHERE userid=?)";
		
		set=super.excuteQuery(sql, parms);
		try {
			while (set.next()) {
				 ju.setId(set.getInt(1));
				 ju.setLodName(set.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		 logger.error(e.getMessage());
		}finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		 
		return ju;
	}
	

}
