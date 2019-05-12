package com.sd.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.constant.Constant;
import com.sd.dao.DemandMapper;
import com.sd.model.AcceptRequireInfo;
import com.sd.model.RequireInfo;
import com.sd.model.TableColum;
import com.sd.service.IDemandService;
@Service
public class DemandServiceImpl implements IDemandService {
	@Autowired
	private DemandMapper demandMapper;
	

	@Override
	public int addData(RequireInfo rInfo) {
		return demandMapper.insertDemand(rInfo);

	}

	@Override
	public void updateData(Map<String, Object> map) {
		String state = (String)map.get("state");
		demandMapper.updateDemandState(map);
		//当状态为2，说明确定竞争者,此时需要更新接收需求表为已签订状态 1
		if (Constant.TWO_CODE.equals(state)) {
			demandMapper.updateAcceptDemandState(map);
		}
	}
	@Override
	public JSONObject queryReInfos(Map<String, Object> map) {
		JSONObject resuJsonObject = new JSONObject();
		List<RequireInfo> list = null;
		int total = 0;
		list = demandMapper.findPublishDemandByUserId(map);
		total = demandMapper.findPublishDemandByUserIdTotal(map);
		resuJsonObject.put("data", this.tranferObject(list));
		resuJsonObject.put("total", total);
		return resuJsonObject;
	}
	
	private List<Map<String, Object>> tranferObject(List<RequireInfo> list){
		List<Map<String, Object>> listObject = new ArrayList<Map<String, Object>>(0);
		for(RequireInfo rInfo:list){
			Map<String, Object> tempMap = new HashMap<String, Object>(0);
			tempMap.put("rid", rInfo.getRid());
			tempMap.put("title", rInfo.getTitle());
			tempMap.put("price", rInfo.getPrice());
			tempMap.put("state", rInfo.getState());
			tempMap.put("creDate", rInfo.getCreDate());
			tempMap.put("userId", rInfo.getUserId());
			tempMap.put("todo", rInfo.getTodo());
			tempMap.put("isUploadPact", rInfo.getIsUploadPact());
			tempMap.put("isUploadWorks", rInfo.getIsUploadWorks());
			tempMap.put("isSure", rInfo.getIsSure());
			listObject.add(tempMap);
		}
		return listObject;
		
	}

	@Override
	public JSONObject queryBidReInfos(Map<String, Object> map) {
		JSONObject resuJsonObject = new JSONObject();
		List<RequireInfo> list = null;
		int total = 0;
		list = demandMapper.findBidDemandByUserId(map);
		total = demandMapper.findBidDemandByUserIdTotal(map);
		resuJsonObject.put("data", this.tranferObject(list));
		resuJsonObject.put("total", total);
		
		return resuJsonObject;
	}

	@Override
	public List<RequireInfo> queryHotRequireInfos() {
		List<RequireInfo> list = null;
		list = demandMapper.findRotDemand();
		return list;
	}

	@Override
	public List<RequireInfo> queryNewRequireInfos() {
		List<RequireInfo> list = null;
		list = demandMapper.findNewDemand();
		return list;
	}

	@Override
	public JSONObject queryPerList(Map<String, Object> map) {
		JSONObject resuJsonObject = new JSONObject();
		List<Map<String, Object>> list = null;
		list = demandMapper.findUserByRid(map);
		int total = demandMapper.findUserByRidTotal(map);
		resuJsonObject.put("data", list);
		resuJsonObject.put("total", total);
		return resuJsonObject;
	}
	@Override
	public RequireInfo queryById(int rid) {
		RequireInfo requireInfo;
		requireInfo = demandMapper.findDemandById(rid);
		return requireInfo;
	}

	@Override
	public JSONObject queryByState(Map<String, Object> map) {
		JSONObject resuJsonObject = new JSONObject();
		List<RequireInfo> list = null;
		int total = 0;
		list = demandMapper.findAllDemandByState(map);
		total = demandMapper.findByStateTotal(map);
		resuJsonObject.put("data", this.tranferObject(list));
		resuJsonObject.put("total", total);		
		return resuJsonObject;
	}
	@Override
	public JSONArray titleInfo(String type) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		List<TableColum> listColumns = initTitles(type);
		jsonObject.put("columns", listColumns);		
		return jsonArray.fromObject(jsonObject);
	}
	/**
	 * 构造需求表头数据
	 * @param type 1：我发布的需求；2：我参与竞标的需求；3：我要报名的需求
	 * @return
	 */
	private static final List<TableColum> initTitles(String type) {
		List<TableColum> list = new ArrayList<TableColum>(0);
		/**主键ID*/
		TableColum tableColum0 = new TableColum();
		tableColum0.setData("rid");
		tableColum0.setTitle("需求ID");
		tableColum0.setOrderable(false);
		tableColum0.setSearch(null);
		tableColum0.setSearchable(false);
		tableColum0.setBvisible(false);
		int tempInt0[] = new int[1];
		tempInt0[0]=0;
		tableColum0.setaTargets(tempInt0);
		list.add(tableColum0);
		/**需求名称*/
		TableColum tableColum1 = new TableColum();
		tableColum1.setData("title");
		tableColum1.setTitle("需求名称");
		tableColum1.setOrderable(false);
		tableColum1.setSearch(null);
		tableColum1.setSearchable(false);
		tableColum1.setBvisible(true);
		int tempInt1[] = new int[1];
		tempInt1[0]=1;
		tableColum1.setaTargets(tempInt1);
		list.add(tableColum1);
		/**需求发布金额*/
		TableColum tableColum2 = new TableColum();
		tableColum2.setData("price");
		tableColum2.setTitle("需求金额");
		tableColum2.setOrderable(false);
		tableColum2.setSearch(null);
		tableColum2.setSearchable(false);
		tableColum2.setBvisible(true);
		int tempInt2[] = new int[1];
		tempInt2[0]=2;
		tableColum2.setaTargets(tempInt2);
		/**需求状态*/
		TableColum tableColum3 = new TableColum();
		tableColum3.setData("state");
		tableColum3.setTitle("需求状态");
		tableColum3.setOrderable(false);
		tableColum3.setSearch(null);
		if (Constant.ONE_CODE.equals(type)) {
			tableColum3.setBvisible(true);
		}else if (Constant.TWO_CODE.equals(type)) {
			tableColum3.setBvisible(false);
		}else if (Constant.THREE_CODE.equals(type)) {
			tableColum3.setBvisible(false);
		}else{
			tableColum3.setBvisible(true);
		}
		tableColum3.setSearchable(false);		
		int tempInt3[] = new int[1];
		tempInt3[0]=3;
		tableColum3.setaTargets(tempInt3);
		list.add(tableColum3);
		/**需求创建时间*/
		TableColum tableColum4 = new TableColum();
		tableColum4.setData("creDate");
		tableColum4.setTitle("需求创建时间");
		tableColum4.setOrderable(false);
		tableColum4.setSearch(null);
		tableColum4.setSearchable(false);
		tableColum4.setBvisible(true);
		int tempInt4[] = new int[1];
		tempInt4[0]=4;
		tableColum4.setaTargets(tempInt4);
		list.add(tableColum4);
		/**需求发布者*/
		TableColum tableColum5 = new TableColum();
		tableColum5.setData("userId");
		tableColum5.setTitle("需求发布者");
		tableColum5.setOrderable(false);
		tableColum5.setSearch(null);
		tableColum5.setSearchable(false);
		if (Constant.ONE_CODE.equals(type)) {
			tableColum5.setBvisible(false);
		}else if (Constant.TWO_CODE.equals(type)) {
			tableColum5.setBvisible(true);
		}else if (Constant.THREE_CODE.equals(type)) {
			tableColum5.setBvisible(true);
		}else{
			tableColum5.setBvisible(true);
		}
		int tempInt5[] = new int[1];
		tempInt5[0]=5;
		tableColum5.setaTargets(tempInt5);
		list.add(tableColum5);
		/**操作列*/
		TableColum tableColum6 = new TableColum();
		tableColum6.setData("todo");
		tableColum6.setTitle("操作");
		tableColum6.setOrderable(false);
		tableColum6.setSearch(null);
		tableColum6.setSearchable(false);
		if (Constant.ONE_CODE.equals(type)) {
			tableColum6.setBvisible(false);
		}else if (Constant.TWO_CODE.equals(type)) {
			tableColum6.setBvisible(false);
		}else if (Constant.THREE_CODE.equals(type)) {
			tableColum6.setBvisible(true);
		}else{
			tableColum6.setBvisible(true);
		}
		int tempInt6[] = new int[1];
		tempInt6[0]=6;
		tableColum6.setaTargets(tempInt6);
		list.add(tableColum6);
		return list;
		
	}

	@Override
	public void addAcceptRequireData(AcceptRequireInfo aInfo) {
		demandMapper.insertAcceptDemand(aInfo);		
	}

	@Override
	public boolean isAccepted(Map<String, Integer> map) {
		int count = demandMapper.isAcceptedDemand(map);
		if (count>0) {
			return true;
		}
		return false;
	}

	@Override
	public void updateByUpload(Map<String, Integer> map) {
		demandMapper.updateDemandByUpload(map);
	}
} 
