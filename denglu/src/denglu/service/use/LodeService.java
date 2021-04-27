package denglu.service.use;

import java.util.List;

import denglu.entity.Juese;

public interface LodeService {
	        // 所有角色
			public List<Juese>  JueseList(int id);
			//用户所扮演的角色
			public   Juese  Juese(int id);
			//用户是否有角色
			public   boolean  JueseCount(int id);
}
