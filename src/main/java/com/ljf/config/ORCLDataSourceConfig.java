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

@Configuration
@MapperScan(basePackages = {"com.ljf.orcl.mapper"}, 
	sqlSessionFactoryRef = "orclsqlSessionFactory",
	sqlSessionTemplateRef = "orclSqlSessionTemplate"
)
//@EnableTransactionManagement(proxyTargetClass = true)
//@EnableAspectJAutoProxy(exposeProxy = true)
public class ORCLDataSourceConfig {

	/**
	 * 配置多数据源，使用派生的子类
	 * 
	 * @return 数据源
	 */
	@Bean(name = "orcldataSource")
	@ConfigurationProperties(prefix = "slave.spring.datasource.orcl")
	public DataSource getORCLDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.type(DynamicDataSource.class);
		return dataSourceBuilder.build();
	}

	/**
	 * orclserver数据库
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "orclsqlSessionFactory")
	public SqlSessionFactory getOrclSessionFactory(@Qualifier("orcldataSource") DataSource dataSource) {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		try {
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean(name = "orclSqlSessionTemplate")
    public SqlSessionTemplate orclSqlSessionTemplate(@Qualifier("orclsqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
 
    //使用方式：@Transactional(transactionManager="sqlserverTransactionManager")
    @Bean
    public PlatformTransactionManager orclTransactionManager(@Qualifier("orcldataSource") DataSource oracleDataSource) {
        return new DataSourceTransactionManager(oracleDataSource);
    }
    
//	/**
//	 * 配置事务管理器
//	 */
//	@Bean
//	@Primary
//	public DataSourceTransactionManager orclTransactionManager(DynamicDataSource dataSource) throws Exception {
//		return new DataSourceTransactionManager(dataSource);
//	}
}
