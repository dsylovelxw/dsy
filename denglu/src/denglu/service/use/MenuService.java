package denglu.service.use;

import java.util.List;

import com.utils.MenudtreeData;

import denglu.entity.Denglu;
import denglu.entity.User;

public interface MenuService {
	
	public User<MenudtreeData> dtreeJson();
	//根据用户Id查询权限信息
		public  List<Denglu> DengluUserID(int id);
}
