package com.core.service;

import com.core.model.User;

/**
*用户信息服务接口
*@author Lewis
*@since 2016-11-04 21:20:36
*/
public interface UserService {

	/**
	 * 根据登录用户名称获取用户信息
	 * @param username 登录用户名
	 * @return User 用户信息
	 */
	User getUserByUsername(String username);

	/**
	 * 保存用户信息
	 * @param userInfo 用户
	 */
	void saveUserInfo(User userInfo);

}
