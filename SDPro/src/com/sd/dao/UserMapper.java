package com.sd.dao;

import java.util.List;
import java.util.Map;

import com.sd.model.User;

public interface UserMapper {
	int insertUser(User user);
	User findUserbyNameAndPwd(Map<String, String> userMap);
	List<User> findUserByName(String username);
}
