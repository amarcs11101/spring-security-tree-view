/**
 * 
 */
package com.abhishek.amar.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abhishek.amar.bean.UIBean;

/**
 * @author Abhishek Amar
 *
 */
public class UiUtils {

	public static UIBean showUITemplate() {
		UIBean ui = new UIBean();
		ui.setNavigation("header");

		List<String> navigationData = new ArrayList<>();
		String s = new String("GENERATE_TOKEN");
		String s1 = new String("HOME");
		String s2 = new String("UPDATE");
		String s3 = new String("DELETE");
		String s4 = new String("VIEW");
		String s5 = new String("SAY IT");

		navigationData.add(s);
		navigationData.add(s1);
		navigationData.add(s2);
		navigationData.add(s3);
		navigationData.add(s4);
		navigationData.add(s5);

		ui.setNavigationDataList(navigationData);

		Map<String, String> map = new HashMap<>();
		map.put("home", "");
		map.put("update", "");
		map.put("delete", "");
		map.put("view", "");
		ui.setComponentName(map);

		ui.setHref("");
		return ui;
	}
}
