package com.core.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.core.model.Menu;
import com.core.model.User;
import com.core.service.MenuService;
import com.core.service.UserService;
import com.core.util.HttpServletUtil;

import net.sf.json.JSONArray;

@Controller
public class LoginUserAction {
	Logger logger = Logger.getLogger(LoginUserAction.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuServiceI;
	
	/**
	 * 跳转至登录页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin(HttpServletRequest request,HttpServletResponse response){
		logger.debug("来自IP[" + request.getRemoteHost() + "]的访问");
		return "login";
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model){
		Map condition = HttpServletUtil.getParameterMap(request);
		String result = "login";
		String username = (String) condition.get("username");
		//MD5加密
		String password = (String)condition.get("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject currentUser = SecurityUtils.getSubject();
		try {
			System.out.println("----------------------------");
			if (!currentUser.isAuthenticated()){
				token.setRememberMe(true);
				currentUser.login(token);
			}
			System.out.println("result: " + result);
			result = "index";
			// 验证成功在Session中保存用户信息
            final User authUserInfo = userService.getUserByUsername(username);
            request.getSession().setAttribute("userInfo", authUserInfo);
            //获取菜单
            List<Menu> menuList = menuServiceI.getMenuList(null);
            model.addAttribute("menuList", JSONArray.fromObject(menuList));
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.addAttribute("error", e.getMessage());
			result = "login";
		}
		return result;
	}
	
	 /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
    
    /**
     * 注册
     * @param request
     * @param response
     * @param model
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/register")
    public String register(HttpServletRequest request,HttpServletResponse response,Model model){
    	Map condition = HttpServletUtil.getParameterMap(request);
    	User userInfo = new User();
    	userInfo.setName((String)condition.get("fullname"));
    	userInfo.setUsername((String)condition.get("username"));
    	userInfo.setPassword((String)condition.get("rpassword"));
    	userInfo.setStatus("1");
    	userInfo.setCreateTime(new Date());
    	try {
    		userService.saveUserInfo(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "redirect:/tologin";
    }
	
}
