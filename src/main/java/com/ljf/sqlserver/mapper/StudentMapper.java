package com.ljf.sqlserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.ljf.entity.Student;

/**
 * 
 * @ClassName:  StudentMapper   
 * @Description:TODO(测试类)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午11:32:56   
 *
 */
@Mapper
public interface StudentMapper {
	
	//查询所有学生信息
	@Results(value = {
			@Result(property="stu_id",column="stu_id"),
			@Result(property="stu_name",column="stu_name"),
			@Result(property="stu_gender",column="stu_gender"),
			@Result(property="stu_age",column="stu_age")
	})
	@Select("select stu_id,stu_name,stu_gender,stu_age from student")
	List<Student> getStudents();
}
