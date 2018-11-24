package com.ljf.orcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ljf.datasource.DBIdentifier;
import com.ljf.orcl.server.ORCLHouseService;
import com.ljf.utils.JsonPackUtils;

/**
 * 
 * @ClassName:  HoseController   
 * @Description:TODO(orcl的housecontroller，给用户调用接口)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月19日 上午10:02:03   
 *
 */
@RestController
@RequestMapping(value = "/house")
public class HoseController {
	
	@Autowired
	private ORCLHouseService houseService;
	
//	@Transactional(transactionManager="orclTransactionManager")
	@RequestMapping(value="/findall",method=RequestMethod.GET)
	public Object findAll(){
		JsonPackUtils jsonPackUtils = new JsonPackUtils();
		try {
			DBIdentifier.setProjectCode("orcl");
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return jsonPackUtils.ok(houseService.findAll(), 0);  
		
		
	}
}
