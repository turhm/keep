/**
 * 
 */
package com.core.service;

import java.util.List;
import java.util.Map;

import com.core.generic.GenericService;
import com.core.model.Menu;

/**
 * 说明：菜单管理service接口
 * @author Lewis
 * @since 2018年3月24日
 */
public interface MenuService extends GenericService<Menu, Long> {

	/**
	 * 根据参数获取菜单集合
	 * @param condition 参数
	 * @return 菜单集合
	 */
	List<Menu> getMenuList(Map<String, String> condition);

}
