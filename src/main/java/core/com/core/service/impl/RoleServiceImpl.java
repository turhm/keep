/**
 * 
 */
package com.core.service.impl;

import org.springframework.stereotype.Service;

import com.core.generic.GenericDao;
import com.core.generic.GenericServiceImpl;
import com.core.model.Role;
import com.core.service.RoleService;

/**
 * 说明：角色服务层接口实现类
 * @author Lewis
 * @since 2018年3月20日
 */
@Service("roleService")
public class RoleServiceImpl  extends GenericServiceImpl<Role, Long> implements RoleService {

	/* (non-Javadoc)
	 * @see com.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<Role, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
