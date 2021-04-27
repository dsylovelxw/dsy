package denglu.service.user.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.utils.DataBaseUtil;

import denglu.dao.BaseDao;
import denglu.dao.impl.LodeDaoImpl;
 
import denglu.service.use.LodeService;

public class LodeServiceImpl  implements LodeService{
	/**
	 * 使用Logger记录日志�?
	 */
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	@Override
	public List<denglu.entity.Juese> JueseList(int id) {
		// TODO Auto-generated method stub
		// 获得连接对象！
		Connection conn = null;
		List<denglu.entity.Juese> jse=null;
		try {
		conn = DataBaseUtil.getConnection();
		
		
		jse=new LodeDaoImpl(conn).JueseList(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return jse;
	}

	@Override
	public denglu.entity.Juese Juese(int id) {
		// TODO Auto-generated method stub
		// 获得连接对象！
				Connection conn = null;
				denglu.entity.Juese easybuyUserLogin = null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					easybuyUserLogin = new  LodeDaoImpl(conn).Juese(id);
				} catch (Exception e) {
					logger.error(e.getMessage());
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return easybuyUserLogin;
	}

	@Override
	public boolean JueseCount(int id) {
		// TODO Auto-generated method stub
				// 获得连接对象！
						Connection conn = null;
						denglu.entity.Juese easybuyUserLogin = null;
						try {
							conn = DataBaseUtil.getConnection();
							// 调用数据访问层代码！
							easybuyUserLogin = new  LodeDaoImpl(conn).Juese(id);
						} catch (Exception e) {
							logger.error(e.getMessage());
						} finally {
							// 释放资源！
							DataBaseUtil.closeAll(null, null, conn);
						}
						
						if(easybuyUserLogin==null || easybuyUserLogin.equals(null)) {
							return  false;
						}else {
							return  true;
						}
						
						
						
	}

}
