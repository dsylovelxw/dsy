package com.dao;

import com.entity.Lr_bumeng;

public interface llc_bumenDao {
	/**
	 * llcд����������
	 * @return
	 */
	int addbumen(Lr_bumeng men);
	/**
	 * llcд��ɾ������
	 * @param id
	 * @return
	 */
	int delbumen(int id);
}
