package com.ljf.sqlserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ljf.entity.Project;

/**
 * 
 * @ClassName:  ProjectMapper   
 * @Description:TODO(查询所有得到项目)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月16日 上午9:42:38   
 *
 */
@Mapper
public interface ProjectMapper {
	
	// 查询所有的项目
	@Results(value = {
			@Result(property="id",column="id"),
			@Result(property="pj_num",column="pj_num"),
			@Result(property="pj_name",column="pj_name"),
			@Result(property="db_ip",column="db_ip"),
			@Result(property="db_names",column="db_names")
	})
	@Select("select id,pj_num,pj_name,db_ip,db_names from project")
	List<Project> getAllProjects();

}
