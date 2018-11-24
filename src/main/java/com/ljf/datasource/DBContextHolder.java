package com.ljf.datasource;

/**
 * 
 * @ClassName:  DBContextHolder   
 * @Description:TODO(保存一个线程安全的DBType容器，并提供向其中设置和获取DBType的方法)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月16日 上午11:05:19   
 *
 */
public class DBContextHolder {	
	private static final ThreadLocal<DBType> contextHolder = new ThreadLocal<>();
	
	public static void setDBType(DBType type) {
		contextHolder.set(type);
	}
	
	public static DBType getDBType() {
		return contextHolder.get();
	}
}
