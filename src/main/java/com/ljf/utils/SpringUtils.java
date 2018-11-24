package com.ljf.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName:  SpringUtils   
 * @Description:TODO(@component （把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>）)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月16日 上午9:25:29   
 *
 */
@Component
public class SpringUtils implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		if (SpringUtils.applicationContext == null) {
			SpringUtils.applicationContext = arg0;
		}
	}
	
	// 获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	// 通过Name获取Bean
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	
	// 通过class获取Bean
	public static <T> T getBean(Class<T> claszz) {
		return getApplicationContext().getBean(claszz);
	}
	
	// 通过name，以及claszz返回指定的bean
	public static <T> T getBean(String name,Class<T> clazz) {
		return getApplicationContext().getBean(name,clazz);
	}

}
