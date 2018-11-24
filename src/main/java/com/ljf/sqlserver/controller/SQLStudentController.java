package com.ljf.sqlserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljf.datasource.DBIdentifier;
import com.ljf.sqlserver.service.StudentService;
import com.ljf.utils.JsonPackUtils;

/**
 * 
 * @ClassName:  StudentController   
 * @Description:TODO(用户访问接口)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 下午1:46:47   
 *
 */
@RestController
@RequestMapping(value="/student")
public class SQLStudentController {
	
	@Autowired
	private StudentService studentService;
	
//	@Transactional(transactionManager="sqlserverSqlSessionTemplate")
	@RequestMapping(value="/findall",method=RequestMethod.GET)
	public Object findAll(@RequestParam(value="projectName",
	required=true) String projectName){
		JsonPackUtils jsonPackUtils = new JsonPackUtils();
		try {
			DBIdentifier.setProjectCode(projectName);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return jsonPackUtils.ok(studentService.findAll(), 0);  
		
		
	}
}
