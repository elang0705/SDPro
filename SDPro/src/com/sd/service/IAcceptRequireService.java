package com.sd.service;

import java.util.List;
import java.util.Map;

import com.sd.model.AcceptRequireInfo;

public interface IAcceptRequireService {
	/**
	 * 接包方数据插入
	 * @param aInfo
	 */
	void addData(AcceptRequireInfo aInfo);
	/**
	 * 接包方数据更新
	 * @param map
	 */
	void updateData(Map<String, Object> map);

}
