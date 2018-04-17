package com.account.DAO;

import com.core.model.User;

/**
*用户信息DAO层接口
*@author Lewis
*@since 2016-11-04 21:20:36
*/
public interface UserMapper {

	/**
	 * 根据登录用户名称获取用户信息
	 * @param username 登录用户名
	 * @return User 用户信息
	 */
	User getUserByUsername(String username);

	/**
	 * 新增用户
	 * @param userInfo
	 */
	void addUserInfo(User userInfo);

}
