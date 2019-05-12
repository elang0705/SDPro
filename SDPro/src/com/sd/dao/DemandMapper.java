package com.sd.dao;

import java.util.List;
import java.util.Map;

import com.sd.model.AcceptRequireInfo;
import com.sd.model.RequireInfo;

public interface DemandMapper {
	int insertDemand(RequireInfo rInfo);
	List<RequireInfo> findRotDemand();
	List<RequireInfo> findNewDemand();
	List<RequireInfo> findPublishDemandByUserId(Map<String, Object> map);
	int findPublishDemandByUserIdTotal(Map<String, Object> map);
	List<RequireInfo> findBidDemandByUserId(Map<String, Object> map);
	int findBidDemandByUserIdTotal(Map<String, Object> map);
	List<Map<String, Object>> findUserByRid(Map<String, Object> map);
	int findUserByRidTotal(Map<String, Object> map);
	RequireInfo findDemandById(int rid);
	void updateDemandState(Map<String, Object> map);
	void updateAcceptDemandState(Map<String, Object> map);
	List<RequireInfo> findAllDemandByState(Map<String, Object> map);
	int findByStateTotal(Map<String, Object> map);
	void insertAcceptDemand(AcceptRequireInfo acceptRequireInfo);
	int isAcceptedDemand(Map<String, Integer> map);
	void updateDemandByUpload(Map<String, Integer> map);
}
