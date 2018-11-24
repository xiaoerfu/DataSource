package com.ljf.utils;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.ljf.datasource.DBIdentifier;
import com.ljf.entity.Project;
import com.ljf.sqlserver.mapper.ProjectMapper;

public class QueryManage extends Thread {
	// 添加之后能够对mapper调用
	private ApplicationContext applicationContext = SpringUtils.getApplicationContext();

	private ProjectMapper projectMapper = applicationContext.getBean(ProjectMapper.class);

	@Override
	public void run() {
		
		DBIdentifier.setProjectCode("project_manage");

		List<Project> projectsList = projectMapper.getAllProjects();
		for (Project project : projectsList) {
			System.out.println("项目名称》》》》》----" + project);
		}
	}
}
