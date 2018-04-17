/**
 * 
 */
package com.core.service;

import java.util.List;
import java.util.Map;

import com.core.generic.GenericService;
import com.core.model.Permission;

/**
 * 说明：权限service层接口
 * @author Lewis
 * @since 2018年3月22日
 */
public interface PermissionService extends GenericService<Permission, Long> {

	/**
	 * 根据用户获取权限
	 * @param username 用户名
	 * @return 权限集合
	 */
	List<Permission> getPerListByUsername(String username);
	
	/**
	 * 根据map集合获取权限
	 * @param condition 参数集合类型
	 * @return 权限集合
	 */
	List<Permission> getPermissionList(Map<String, String> condition);
	
}
