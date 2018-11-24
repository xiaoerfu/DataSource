package com.ljf.datasource;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * 
 * @ClassName:  DynamicDataSource   
 * @Description:TODO(从DataSource派生了一个DynamicDataSource，在其中实现数据库连接的动态切换)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午9:49:01   
 *
 */
public class DynamicDataSource extends DataSource {

	private static Logger log = LogManager.getLogger(DynamicDataSource.class);
	 
    /**
     * 改写本方法是为了在请求不同工程的数据时去连接不同的数据库。
     */
    @Override
    public Connection getConnection(){
 
        String projectCode = DBIdentifier.getProjectCode();
 
        //1、获取数据源
        DataSource dds = DDSHolder.instance().getDDS(projectCode);
 
        //2、如果数据源不存在则创建
        if (dds == null) {
            try {
                DataSource newDDS = initDDS(projectCode);
                DDSHolder.instance().addDDS(projectCode, newDDS);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                log.error("Init data source fail. projectCode:" + projectCode);
                return null;
            }
        }
 
        dds = DDSHolder.instance().getDDS(projectCode);
        try {
            return dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
 
    /**
     * 以当前数据对象作为模板复制一份。
     * 
     * @return dds
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    private DataSource initDDS(String projectCode) throws IllegalArgumentException, IllegalAccessException {
 
        DataSource dds = new DataSource();
 
        // 2、复制PoolConfiguration的属性
        PoolProperties property = new PoolProperties();
        Field[] pfields = PoolProperties.class.getDeclaredFields();
        for (Field f : pfields) {
            f.setAccessible(true);
            Object value = f.get(this.getPoolProperties());
 
            try
            {
                f.set(property, value);             
            }
            catch (Exception e)
            {
                //有一些static final的属性不能修改。忽略。
                log.info("Set value fail. attr name:" + f.getName());
                continue;
            }
        }
        dds.setPoolProperties(property);
 
        // 3、设置数据库名称和IP(一般来说，端口和用户名、密码都是统一固定的)
        String urlFormat = this.getUrl();
        //jdbc:sqlserver://%s:9999;Databasename=%s
        //jdbc:sqlserver://192.168.1.222:9999;Databasename=project_manage
        System.out.println("数据库地址：>>>>--------" + urlFormat);
        String url = String.format(urlFormat, ProjectDBMgr.instance().getDBIP(projectCode), 
                ProjectDBMgr.instance().getDBName(projectCode));
        System.out.println("数据库地址：>>>>--------" + ProjectDBMgr.instance().getDBIP(projectCode) 
        		+"--" +
        		ProjectDBMgr.instance().getDBName(projectCode)
        		+ "--" +
        		url);
        dds.setUrl(url);
 
        return dds;
    }
}
