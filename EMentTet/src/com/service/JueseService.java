package com.service;

import java.util.List;

import com.entity.Juese;
import com.entity.Layui;
import com.entity.Lr_bumeng;
import com.entity.Lr_zhicheng;
import com.entity.Meun;
import com.entity.User;

public interface JueseService {
	 //���н�ɫ��ѯ
    public List<Juese> jueseList();
    //��ɫ�ĸ���
	   public int CountJuese();
	   //���в��Ų�ѯ
	   public List<Lr_bumeng> Lr_bumengList();
		//���ŵĸ���
	   public int CountLr_bumeng();
	   //����ְ�Ʋ�ѯ
		public List<Lr_zhicheng> Lr_zhichengList();
	   //ְ�Ƶĸ���
		public int CountLr_zhicheng();
	 
		Layui<User>  jueseLists( );
}
