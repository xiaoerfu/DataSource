package com.ljf.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * 
 * @ClassName:  DDSTimer   
 * @Description:TODO(动态数据源定时器管理，长时间无访问的数据库链接关闭)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午10:42:43   
 *
 */
public class DDSTimer {
	
	// 空闲时间周期，超过这个时长没有访问的数据库链接将被释放，默认为10分钟
	private static long idlePeriodTime = 10 * 60 * 1000;
	
	// 动态数据源
	private DataSource dds;
	
	// 上一次的访问时间
	private long lastUserTime;
	
	public DDSTimer(DataSource dds) {
		this.dds = dds;
		this.lastUserTime = System.currentTimeMillis();
	}
	
	// 更新最近访问时间
	public void refreshTime() {
		lastUserTime = System.currentTimeMillis();
	}
	
	public boolean checkAndClose() {
		if (System.currentTimeMillis() - lastUserTime > idlePeriodTime) {
			dds.close();
			return true;
		}
		return false;
	}
	
	public DataSource getDds() {
		return dds;
	}
}
