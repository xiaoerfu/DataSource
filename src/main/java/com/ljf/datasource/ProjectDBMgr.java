package com.ljf.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.ljf.entity.Project;
import com.ljf.sqlserver.mapper.ProjectMapper;
import com.ljf.utils.QueryManage;
import com.ljf.utils.SpringUtils;

/**
 * 
 * @ClassName:  ProjectDBMgr   
 * @Description:TODO(管理项目编码与数据库IP和名称的映射关系)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午10:10:21   
 *
 */
public class ProjectDBMgr {
	
	/**
     * 保存项目编码与数据名称的映射关系。这里是硬编码，实际开发中这个关系数据可以保存到redis缓存中；
     * 新增一个项目或者删除一个项目只需要更新缓存。到时这个类的接口只需要修改为从缓存拿数据。
     */
    private Map<String, String> dbNameMap = new HashMap<String, String>();
 
    /**
     * 保存项目编码与数据库IP的映射关系。
     */
    private Map<String, String> dbIPMap = new HashMap<String, String>();
 
    private ProjectDBMgr() {
    	
//    	QueryManage queryManage = new QueryManage();
//    	queryManage.start();
//    	
//    	try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
		String address = "jdbc:sqlserver://192.168.1.222:9999;Databasename=project_manage";
		String dbuser = "sa";
		String dbpasswd = "mh@803";
		String database = "project_manage";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(address, dbuser, dbpasswd);
			con.setCatalog(database);

			Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String selCode = "select id,pj_num,pj_name,db_ip,db_names from project order by pj_num";
			ResultSet rs = smt.executeQuery(selCode);
			while (rs.next()) {
				dbNameMap.put(rs.getString("pj_name").toString(), rs.getString("db_names").toString());
				dbIPMap.put(rs.getString("pj_name").toString(), rs.getString("db_ip").toString());
			}
			con.close();
			smt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据库名------------》" + dbNameMap.toString());
		System.out.println("数据库ip------------》" + dbIPMap.toString());
    	
//    	dbNameMap.put("project_001", "student_score");
//        dbNameMap.put("project_manage", "project_manage");
//        dbNameMap.put("project_003", "db_project_003");
// 
//        dbIPMap.put("project_001", "192.168.1.222");
//        dbIPMap.put("project_manage", "192.168.1.222");
//        dbIPMap.put("project_003", "127.0.0.1");
    }
 
    public static ProjectDBMgr instance() {
        return ProjectDBMgrBuilder.instance;
    }
 
    // 实际开发中改为从缓存获取
    public String getDBName(String projectCode) {
    	System.out.println(dbNameMap.toString());
        if (dbNameMap.containsKey(projectCode)) {
            return dbNameMap.get(projectCode);
        }
 
        return "";
    }
 
    //实际开发中改为从缓存中获取
    public String getDBIP(String projectCode) {
    	System.out.println(dbIPMap.toString());
        if (dbIPMap.containsKey(projectCode)) {
            return dbIPMap.get(projectCode);
        }
 
        return "";
    }
 
    private static class ProjectDBMgrBuilder {
        private static ProjectDBMgr instance = new ProjectDBMgr();
    }
    
}
