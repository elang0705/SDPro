package com.sd.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sd.model.AcceptRequireInfo;
import com.sd.model.RequireInfo;

public interface IDemandService {
	/**
	 * 发布需求插入数据库
	 * @param rInfo
	 */
	int addData(RequireInfo rInfo);
	/**
	 * 更新需求状态
	 * @param map
	 */
	void updateData(Map<String, Object> map);
	/**
	 * 根据上传的附件更新需求表
	 * @param map
	 */
	void updateByUpload(Map<String, Integer> map);
	/**
	 * 查询个人发布的需求列表
	 * @param map
	 * @return
	 */
	JSONObject queryReInfos(Map<String, Object> map);
	/**
	 * 查询我参与竞标的需求
	 * @param map
	 * @return
	 */
	JSONObject queryBidReInfos(Map<String, Object> map);
	/**
	 * 查询热门需求
	 * @return
	 */
	List<RequireInfo> queryHotRequireInfos();
	/**
	 * 查询最新需求
	 * @return
	 */
	List<RequireInfo> queryNewRequireInfos();
	/**
	 * 查询某需求参与竞标者列表
	 * @param rid
	 * @return
	 */
	JSONObject queryPerList(Map<String, Object> map);
	/**
	 * 根据需求id查询需求
	 * @param rid
	 * @return
	 */
	RequireInfo queryById(int rid);
	/**
	 * 根据状态查询需求
	 * @param rid
	 * @return
	 */
	JSONObject queryByState(Map<String, Object> map);
	/**
	 * 构造表头信息
	 * @return
	 */
	JSONArray titleInfo(String type);
	/**
	 * 报名需求插入竞标需求数据
	 * @param rInfo
	 */
	void addAcceptRequireData(AcceptRequireInfo aInfo);
	/**
	 * 是否已经报名此需求
	 * @param map
	 * @return
	 */
	boolean isAccepted(Map<String, Integer> map);
	
}
