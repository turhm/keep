/**
 * 
 */
package com.account.DAO;

import java.util.List;
import java.util.Map;

import com.core.generic.GenericDao;
import com.core.model.Permission;

/**
 * 说明：权限DAO
 * @author Lewis
 * @since 2018年3月22日
 */
public interface PermissionMapper extends GenericDao<Permission, Long> {

	/**
	 * 根据map集合获取权限
	 * @param condition 参数集合类型
	 * @return 权限集合
	 */
	List<Permission> getPermissionList(Map<String, String> condition);

}
