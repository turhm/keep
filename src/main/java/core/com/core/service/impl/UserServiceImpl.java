package com.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.DAO.UserMapper;
import com.core.model.User;
import com.core.service.UserService;

/**
*用户信息服务接口实现类
*@author Lewis
*@since 2016-11-04 21:20:36
*/
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByUsername(String username)  {
		return userMapper.getUserByUsername(username);
	}

	@Override
	public void saveUserInfo(User userInfo) {
		userMapper.addUserInfo(userInfo);
	}

}
