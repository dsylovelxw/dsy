package com.dao;

import java.util.List;

import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.User;

 

public interface UserDao {
	//��ѯ�����û�
public List<User> UserList();
//��ѯ���в���
public List<Lr_bumeng> Lr_bumengList();
//��ѯ���в���ְ��
public List<Lr_zhicheng> Lr_zhichengList();
//�޸��û���Ϣ
public int updateUserByAdmin(User user);
//��ѯ�û��Ƿ����
public int CountUser(String name);
//�����û���Ϣ
public int InsertaddUser(User user);
//ɾ���û���Ϣ
public int DeleteaddUser(int  userid);

public User  UserFinde(int  userid);
public int InsertaddUser(int userid,int mentid);

}
