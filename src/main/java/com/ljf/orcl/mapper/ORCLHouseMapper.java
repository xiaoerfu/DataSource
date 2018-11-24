package com.ljf.orcl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ljf.entity.House;

/**
 * 
 * @ClassName:  HouseMapper   
 * @Description:TODO(主类数据库测试)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 下午5:17:38   
 *
 */
@Mapper
public interface ORCLHouseMapper {
	
	//查询所有学生信息
	@Results(value = {
			@Result(property="id",column="id"),
			@Result(property="house_name",column="house_name"),
			@Result(property="parent_id",column="parent_id")
	})
	@Select("select id,house_name,parent_id from house")
	List<House> getHouses();

}
