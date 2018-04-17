/**
 * 
 */
package com.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.DAO.MenuMapper;
import com.core.generic.GenericDao;
import com.core.generic.GenericServiceImpl;
import com.core.model.Menu;
import com.core.service.MenuService;

/**
 * 说明：菜单管理service实现类
 * @author Lewis
 * @since 2018年3月24日
 */
@Service("menuServiceI")
public class MenuServiceImpl extends GenericServiceImpl<Menu, Long> implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public GenericDao<Menu, Long> getDao() {
		return menuMapper;
	}

	/**
	 * 根据参数获取菜单集合
	 * @param condition 参数
	 * @return 菜单集合
	 */
	@Override
	public List<Menu> getMenuList(Map<String, String> condition) {
		List<Menu> menuList = new ArrayList<Menu>();
		List<Menu> rootMenu = menuMapper.getMenuList(condition);
		 // 先找到所有的一级菜单
	    for (int i = 0; i < rootMenu.size(); i++) {
	        // 一级菜单没有parentId
	    	if (rootMenu.get(i).getParent_id() == null) {
	            menuList.add(rootMenu.get(i));
	        }
	    }
	    // 为一级菜单设置子菜单，getChild是递归调用的
	    for (Menu menu : menuList) {
	        menu.setChildMenus(getChild(menu.getId(), rootMenu));
	    }
		return menuList;
	}
	
	/**
	 * 递归查找子菜单
	 * 
	 * @param id
	 *            当前菜单id
	 * @param rootMenu
	 *            要查找的列表
	 * @return
	 */
	private List<Menu> getChild(Long id, List<Menu> rootMenu) {
	    // 子菜单
	    List<Menu> childList = new ArrayList<>();
	    for (Menu menu : rootMenu) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        if (menu.getParent_id() != null) {
	            if (menu.getParent_id()==id) {
	                childList.add(menu);
	            }
	        }
	    }
	    // 把子菜单的子菜单再循环一遍
	    for (Menu menu : childList) {// 没有url子菜单还有子菜单
	        if (StringUtils.isBlank(menu.getUrl())) {
	            // 递归
	            menu.setChildMenus(getChild(menu.getId(), rootMenu));
	        }
	    } // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	}

}
