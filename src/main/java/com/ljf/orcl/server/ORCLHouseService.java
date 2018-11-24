package com.ljf.orcl.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljf.entity.House;
import com.ljf.orcl.mapper.ORCLHouseMapper;

/**
 * 
 * @ClassName:  HouseService   
 * @Description:TODO(主数据库测试服务类，实现增删查改)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 下午5:20:34   
 *
 */
@Service
public class ORCLHouseService {
	
	@Autowired
	private ORCLHouseMapper houseMapper;
	
	// 查询全部内容
//	@DataSource
	@Transactional(value="orclTransactionManager")
	public List<House> findAll(){
		return houseMapper.getHouses();
	}

}