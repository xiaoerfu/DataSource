package com.ljf.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ljf.datasource.DynamicDataSource;

/**
 * 
 * @ClassName: DataSourceConfig
 * @Description:TODO(数据源配置管理)
 * @author: 铭汉科技—LJF
 * @date: 2018年11月15日 上午9:15:52
 *
 */
@Configuration
@MapperScan(basePackages = "com.ljf.sqlserver.mapper", 
	sqlSessionFactoryRef = "sqlserverSqlSessionFactory",
	sqlSessionTemplateRef = "sqlserverSqlSessionTemplate"
)
//@EnableTransactionManagement(proxyTargetClass = true)
//@EnableAspectJAutoProxy(exposeProxy = true)
public class SQLDataSourceConfig {

	/**
	 * 配置多数据源，使用派生的子类
	 * 
	 * @return 数据源
	 */
	@Bean(name = "sqlDataSource")
	@Primary //必须加此注解，不然报错，下一个类则不需要添加
	@ConfigurationProperties(prefix = "master.spring.datasource.sqlserver")
	public DataSource getSQLDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.type(DynamicDataSource.class);
		return dataSourceBuilder.build();
	}

	/**
	 * SQLserver数据库
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "sqlserverSqlSessionFactory")
	@Primary
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("sqlDataSource") DataSource dataSource) {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		try {
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Bean(name = "sqlserverSqlSessionTemplate")
	@Primary
    public SqlSessionTemplate sqlserverSqlSessionTemplate(@Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
 
    //使用方式：@Transactional(transactionManager="sqlserverTransactionManager")
    @Bean
    @Primary
    public PlatformTransactionManager sqlserverTransactionManager(@Qualifier("sqlDataSource") DataSource oracleDataSource) {
        return new DataSourceTransactionManager(oracleDataSource);
    }

//	/**
//	 * 配置事务管理器
//	 */
//	@Bean
//	@Primary
//	public DataSourceTransactionManager sqlTransactionManager(DynamicDataSource dataSource) throws Exception {
//		return new DataSourceTransactionManager(dataSource);
//	}

}
