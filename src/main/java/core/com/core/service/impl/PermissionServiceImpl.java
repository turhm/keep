/**
 * 
 */
package com.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.DAO.PermissionMapper;
import com.core.generic.GenericDao;
import com.core.generic.GenericServiceImpl;
import com.core.model.Permission;
import com.core.service.PermissionService;

/**
 * 说明：权限service层接口实现类
 * @author Lewis
 * @since 2018年3月22日
 */
@Service("permissionService")
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	
	/* (non-Javadoc)
	 * @see com.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<Permission, Long> getDao() {
		return permissionMapper;
	}

	/**
	 * 根据用户获取权限
	 * @param username 用户名
	 * @return 权限集合
	 */
	@Override
	public List<Permission> getPerListByUsername(String username) {
		Map<String, String> condition = new HashMap<String, String>();
		condition.put("username", username);
		return this.getPermissionList(condition);
	}

	/**
	 * 根据map集合获取权限
	 * @param condition 参数集合类型
	 * @return 权限集合
	 */
	@Override
	public List<Permission> getPermissionList(Map<String, String> condition) {
		return permissionMapper.getPermissionList(condition);
	}

}
