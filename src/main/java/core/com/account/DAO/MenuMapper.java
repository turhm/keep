/**
 * 
 */
package com.account.DAO;

import java.util.List;
import java.util.Map;

import com.core.generic.GenericDao;
import com.core.model.Menu;

/**
 * 说明：菜单管理DAO
 * @author Lewis
 * @since 2018年3月24日
 */
public interface MenuMapper extends GenericDao<Menu, Long> {

	/**
	 * 根据参数获取菜单集合
	 * @param condition 参数
	 * @return 菜单集合
	 */
	List<Menu> getMenuList(Map<String, String> condition);

}
