package com.core.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.core.model.Permission;
import com.core.model.User;
import com.core.service.PermissionService;
import com.core.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm {
	private Logger logger= Logger.getLogger(ShiroDbRealm.class); 
	private static final String ALGORITHM = "MD5";

	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService permissionService;
	
	/** 
     * 判断此realm是否支持此token 
     * @param authenticationToken 
     * @return 
     */  
    @Override  
    public boolean supports(AuthenticationToken authenticationToken) {  
    	//是否支持用户名登录的token  
        return authenticationToken instanceof UsernamePasswordToken;  
    }  
	
    /**
     * 授权的信息
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//主的 身份信息
        String username = principals.getPrimaryPrincipal().toString();
        List<Permission> permissionList = permissionService.getPerListByUsername(username);
        List<String> permissions = new ArrayList<String>();
        for (Permission permission : permissionList) {
        	//权限添加
        	permissions.add(permission.getPermissionSign());
		}
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
      //给当前用户分配权限
        info.addStringPermissions(permissions);
        return info;
	}

	/**
	 * 认证回调函数, 登录时调用
	 * 获取身份验证相关信息 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) 
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println(token.getUsername());
		User user = userService.getUserByUsername(token.getUsername());
		if (user != null) {
			if(!String.valueOf(token.getPassword()).equals(user.getPassword())){
				throw new IncorrectCredentialsException("密码错误！");  
			}
			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		}else{
			throw new UnknownAccountException("用户不存在！");
		}
	}

}
