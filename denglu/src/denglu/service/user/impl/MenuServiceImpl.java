package denglu.service.user.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

 
import com.utils.DataBaseUtil;
import com.utils.MenudtreeData;

import denglu.dao.impl.QuanDaoImpl;
import denglu.entity.Denglu;
import denglu.entity.User;
import denglu.service.use.MenuService;

public class MenuServiceImpl implements MenuService{

	@Override
	public User<MenudtreeData> dtreeJson() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<MenudtreeData> dengt = new ArrayList<MenudtreeData>();
	 
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();
		User<MenudtreeData> user=new User<MenudtreeData>();
		List<Denglu> Deng=new   QuanDaoImpl(conn).DengluUser(0);
		 
				for (Denglu menu : Deng) {
					MenudtreeData data = new MenudtreeData();
					data.setId( menu.getId() ); 
					data.setParentId(menu.getFatherid() ); 
					data.setTitle(menu.getmName());
					data.setCheckArr ("0");
					dengt.add(data);
				}
		user.setCode(0);
		user.setCount(10);
		user.setData(dengt);
		user.setMsg("");
		 
		return user;
	}

	@Override
	/*
	 * 
	 * (non-Javadoc)
	 * @see denglu.service.use.MenuService#DengluUserID(int)
	 */
	public List<Denglu> DengluUserID(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;		  
			// 获取连接对象�?
			conn = DataBaseUtil.getConnection();		 
		List<Denglu> Deng=new   QuanDaoImpl(conn).DengluUserID(id);		 
		return Deng;
	}

}
