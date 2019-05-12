package com.sd.service;

import java.util.Map;

import com.sd.model.PersonInfo;

public interface IPersonInfoService {
	/**
	 * 完善个人信息
	 * @param pInfo
	 */
	void addData(PersonInfo pInfo);
	/**
	 * 更新个人信息
	 * @param map
	 */
	void updateData(PersonInfo personInfo);
	/**
	 * 查询个人信息
	 * @param id
	 * @return
	 */
	PersonInfo queryPersonInfo(int id);

}
