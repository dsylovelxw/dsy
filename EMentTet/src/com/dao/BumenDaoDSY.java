package com.dao;

import com.entity.Lr_bumeng;

public interface BumenDaoDSY {
	//�����������ݵĻ���
	public Lr_bumeng Lr_bumengFind(int id);
	
	//���ŵ��޸�
	   public int  UpdateLr_bumeng(Lr_bumeng bumen);
	   //���������Ƿ��ظ�
	   public int NameLr_bumen(String name);
}
