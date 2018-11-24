package com.ljf;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
	     * 保存项目编码与数据名称的映射关系。这里是硬编码，实际开发中这个关系数据可以保存到redis缓存中；
	     * 新增一个项目或者删除一个项目只需要更新缓存。到时这个类的接口只需要修改为从缓存拿数据。
	     */
	    Map<String, String> dbNameMap = new HashMap<String, String>();
	 
	    /**
	     * 保存项目编码与数据库IP的映射关系。
	     */
	    Map<String, String> dbIPMap = new HashMap<String, String>();
	 
	        dbNameMap.put("project_001", "student_score");
	        dbNameMap.put("project_002", "db_project_002");
	        dbNameMap.put("project_003", "db_project_003");
	 
	        dbIPMap.put("project_001", "192.168.1.222");
	        dbIPMap.put("project_002", "127.0.0.1");
	        dbIPMap.put("project_003", "127.0.0.1");
	        
	        if (dbNameMap.containsKey("project_001")) {
	            System.out.println(dbNameMap.get("project_001"));
	        }
	        
	        if (dbIPMap.containsKey("project_001")) {
	            System.out.println(dbNameMap.get("project_001"));
	        }

	}

}
