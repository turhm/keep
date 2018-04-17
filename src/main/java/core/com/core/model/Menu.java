/**
 * 
 */
package com.core.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 说明：菜单
 * @author Lewis
 * @since 2018年3月24日
 */
@Alias(value="Menu")
public class Menu {
	private Long id;
	private String code;
	private String name;
	private Long parent_id;
	private String url;
	//菜单图标icon
	private String icon;
	// 子菜单
    private List<Menu> childMenus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Menu> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
