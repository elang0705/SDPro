package com.sd.dao;

import java.util.Map;

import com.sd.model.AcceptRequireInfo;

public interface AcceptRequireMapper {
	void insertAcceptRequire(AcceptRequireInfo aInfo);
	void updateState(Map<String, Object> map);
}
