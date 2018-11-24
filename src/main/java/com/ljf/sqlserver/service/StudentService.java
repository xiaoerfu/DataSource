package com.ljf.sqlserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljf.entity.Student;
import com.ljf.sqlserver.mapper.StudentMapper;

/**
 * 
 * @ClassName:  StudentService   
 * @Description:TODO(学生类的服务类，实现增删查改)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午11:54:44   
 *
 */
@Service
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	// 查询全部内容
	@Transactional
	public List<Student> findAll(){
		return studentMapper.getStudents();
	}

}
