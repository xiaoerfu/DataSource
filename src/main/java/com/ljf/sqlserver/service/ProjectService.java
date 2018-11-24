package com.ljf.sqlserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljf.entity.Project;
import com.ljf.sqlserver.mapper.ProjectMapper;

/**
 * 
 * @ClassName:  ProjectService   
 * @Description:TODO(项目服务类，调用Mapper类，实现增删查改操作)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月16日 上午9:50:43   
 *
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	// 查询所有的项目名
	@Transactional
	List<Project> getAllProjects(){
		return projectMapper.getAllProjects();
	}
}
