/**
 * 
 */
package com.abhishek.amar.bean;

import java.util.List;
import java.util.Map;

/**
 * @author Abhishek Amar
 *
 */
public class UIBean {
	private String navigation;
	private String href;
	private List<String> navigationDataList;
	private Map<String, String> componentName;

	public String getNavigation() {
		return navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<String> getNavigationDataList() {
		return navigationDataList;
	}

	public void setNavigationDataList(List<String> navigationDataList) {
		this.navigationDataList = navigationDataList;
	}

	public Map<String, String> getComponentName() {
		return componentName;
	}

	public void setComponentName(Map<String, String> componentName) {
		this.componentName = componentName;
	}

}
