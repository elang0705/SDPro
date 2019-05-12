package com.sd.service.Impl;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sd.dao.AcceptRequireMapper;
import com.sd.model.AcceptRequireInfo;
import com.sd.service.IAcceptRequireService;
@Service
public class AcceptRequireServiceImpl implements IAcceptRequireService {
	@Autowired
	private AcceptRequireMapper acceptRequireMapper;

	@Override
	public void addData(AcceptRequireInfo aInfo) {
		acceptRequireMapper.insertAcceptRequire(aInfo);
	}

	@Override
	public void updateData(Map<String, Object> map) {
		acceptRequireMapper.updateState(map);

	}
}
