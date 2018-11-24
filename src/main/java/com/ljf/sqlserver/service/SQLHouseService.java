package com.ljf.sqlserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljf.entity.House;
import com.ljf.sqlserver.mapper.HouseMapper;

/**
 * 
 * @ClassName:  HouseService   
 * @Description:TODO(主数据库测试服务类，实现增删查改)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 下午5:20:34   
 *
 */
@Service
public class SQLHouseService {
	
	@Autowired
	private HouseMapper houseMapper;
	
	// 查询全部内容
	@Transactional
	public List<House> findAll(){
		return houseMapper.getHouses();
	}

}
