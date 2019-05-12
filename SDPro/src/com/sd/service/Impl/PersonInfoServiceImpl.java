package com.sd.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sd.dao.PersonInfoMapper;
import com.sd.model.PersonInfo;
import com.sd.service.IPersonInfoService;
@Service
public class PersonInfoServiceImpl implements IPersonInfoService {
	@Autowired
	private PersonInfoMapper personInfoMapper;

	@Override
	public void addData(PersonInfo pInfo) {
		personInfoMapper.insertPersonInfo(pInfo);
	}

	@Override
	public void updateData(PersonInfo personInfo) {
		personInfoMapper.modifyInfo(personInfo);
	}

	@Override
	public PersonInfo queryPersonInfo(int pid) {
		PersonInfo personInfo = null;
		personInfo = personInfoMapper.findDemandById(pid);
		return personInfo;
	}

}
