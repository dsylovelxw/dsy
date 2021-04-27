package denglu.service.use;

import denglu.entity.EasybuyUser;

public interface UserService {
public EasybuyUser allUserByUserid(int id);
public int updateUserByAdmin( EasybuyUser user);
public boolean CountEasybuyUser(String name);
public int insertUser( EasybuyUser user);

}
