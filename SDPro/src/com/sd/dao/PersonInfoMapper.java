package com.sd.dao;

import com.sd.model.PersonInfo;

public interface PersonInfoMapper {
	void insertPersonInfo(PersonInfo pInfo);
    PersonInfo findDemandById(int pid);
    void modifyInfo(PersonInfo personInfo);
}
