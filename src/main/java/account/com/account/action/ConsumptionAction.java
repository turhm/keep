/**
 * 
 */
package com.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.account.service.ConsumptionService;

/**
 * 说明：支出管理
 * @author Lewis
 * @since 2018年3月27日
 */
@Controller
public class ConsumptionAction {
	Logger logger = Logger.getLogger(ConsumptionAction.class);
	@Autowired
	private ConsumptionService consumptionService;
	
	@RequestMapping(value = "/consume/consumeInput")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model){
		
		return "consume/consumeInput";
	}
}
