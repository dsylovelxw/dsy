package com.service;

import com.entity.Lr_bumeng;

public interface llc_bumenService {
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
