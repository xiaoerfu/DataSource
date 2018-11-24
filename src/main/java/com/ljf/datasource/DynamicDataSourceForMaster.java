package com.ljf.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @ClassName:  DynamicDataSourceForMaster   
 * @Description:TODO(动态数据源（需要继承AbstractRoutingDataSource）
 * 使用DBContextHolder获取当前线程的DBType)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月16日 上午11:12:12   
 *
 */
public class DynamicDataSourceForMaster extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DBContextHolder.getDBType();
	}

}
