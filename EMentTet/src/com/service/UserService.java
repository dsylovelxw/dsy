package com.service;

 

import java.util.List;

import com.entity.Layui;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.User;

public interface UserService {
	public Layui<User> UserList() ;
	//��ѯ�����û�
public List<User> UserListss();
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

public int InsertaddUser(int userid,int mentid);
public User UserFind(int userid);

}
