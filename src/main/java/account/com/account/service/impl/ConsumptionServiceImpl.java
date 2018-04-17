/**
 * 
 */
package com.account.service.impl;

import org.springframework.stereotype.Service;

import com.account.model.Consumption;
import com.account.service.ConsumptionService;
import com.core.generic.GenericDao;
import com.core.generic.GenericServiceImpl;

/**
 * 说明：支出管理实现类
 * @author Lewis
 * @since 2018年3月27日
 */
@Service("consumptionService")
public class ConsumptionServiceImpl extends GenericServiceImpl<Consumption, Long> implements ConsumptionService {

	/* (non-Javadoc)
	 * @see com.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<Consumption, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
