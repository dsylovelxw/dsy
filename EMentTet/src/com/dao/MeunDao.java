package com.dao;

import java.util.List;

import com.entity.Juese;
import com.entity.Meun;
import com.entity.User;
import com.utils.Butn;
 
 

public interface MeunDao {
	//Ȩ��������ѯ
	public  List<Meun> QuanxianFind(int id,int iid);
	//Ȩ�޲�ѯ
	List<Meun> DengluUser(int id);
	//Ȩ�޸�����ѯ
	public int CountDengluUser();
	 
		//��¼�û���Ϣ��ѯ
		public User DengluYong(String name);
		
		//�û��ܸ�����ѯ
		public int CountEasybuyUser();
		//�û�������Ϣ��ѯ
		public  List<User> EasybuyUserList(String name);
		
		//�û������ݵĽ�ɫ
		public List<Juese>  JueseList(int id);
		//��ѯ�û�����Ȩ�����Ƿ��ظ�
		public int   QuanxianCount(String name);
		//  ��֤����·���Ƿ����
		public int    isMenuUrl(String mbtn);
		//Ȩ����Ϣ��ѯ
				public Meun quanxMeuncha(int deng);
		//����Ȩ����Ϣ
		public int addDenglu(Meun deng);
		//�޸�Ȩ����Ϣ
		public int UpdateDenglu(Meun deng);
		//ɾ��Ȩ����Ϣ
		public int DeleteDenglu(int id);
		//�����û���ɫid��ѯȨ����Ϣ
		public  List<Meun> DengluUserID(int id);
		
		public List<Butn> ButnFan(int id);
		public List<Meun> menuByBtn3(int type) ;
}
