package com.sd.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.dao.UserMapper;
import com.sd.model.User;
import com.sd.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		int result = userMapper.insertUser(user);
		return result;
	}

	@Override
	public User queryUserByusernameAndPwd(String username, String pwd) {
		Map<String, String> userMap = new HashMap<String, String>(0);
		userMap.put("username", username);
		userMap.put("pwd", pwd);
		return userMapper.findUserbyNameAndPwd(userMap);
	}

	@Override
	public List<User> queryUserByusername(String username) {
		List<User> list = null;
		list = userMapper.findUserByName(username);
		return list;
	}
}
