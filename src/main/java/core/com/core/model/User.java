package com.core.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
	*此类由MySQLToBean工具自动生成
	*@author Lewis
	*@since 2016-11-04 21:20:36
	*/

@Alias(value="User")
public class User{
	private Integer id;//主键ID
	private String username;//登录用户名
	private String password;//密码
	private String name;//用户名
	private String status;//状态:0：启用，1禁用
	private Date createTime;//创建时间
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}