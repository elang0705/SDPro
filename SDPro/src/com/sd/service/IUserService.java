package com.sd.service;
import java.util.List;
import com.sd.model.User;


public interface IUserService {
	/**
	 * 功能：注册用户
	 * @param user
	 */
	int addUser(User user);//注册用户
	/**
	 * 功能：根据用户名密码查询用户
	 * @param username
	 * @param pwd
	 * @return
	 */
	User queryUserByusernameAndPwd(String username,String pwd);
	/**
	 * 功能：根据用户名查询用户
	 * @param username
	 * @return
	 */
	List<User> queryUserByusername(String username);
}
