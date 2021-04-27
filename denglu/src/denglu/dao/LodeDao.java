package denglu.dao;

import java.util.List;

import denglu.entity.Juese;

public interface LodeDao {

	    // 所有角色
		public List<Juese>  JueseList(int id);
		//用户所扮演的角色
		public   Juese  Juese(int id);
}
