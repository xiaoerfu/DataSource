package com.ljf.datasource;

/**
 * 
 * @ClassName:  DBIdentifier   
 * @Description:TODO(数据库标识类，用于区分不同的数据库)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午9:44:24   
 *
 */

public class DBIdentifier {
	
	private static ThreadLocal<String> projectCode = new ThreadLocal<String>();

	public static String getProjectCode() {
		return projectCode.get();
	}

	public static void setProjectCode(String projectCode) {
		System.out.println(projectCode);
		DBIdentifier.projectCode.set(projectCode);
	}
	
	
}
