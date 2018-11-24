package com.ljf.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JsonPackUtils {
	
	/**
	 * 正确返回 状态为200
	 * @param <T>
	 * @param listArray
	 * @return
	 */
	public <T> Object ok(List<T> listArray, int not_uploaded) {
//        PageHelper.startPage(1,10);
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        map.put("msg","ok");
        map.put("data",listArray);
        map.put("not_upload_num", not_uploaded);
        String res = JSON.toJSONString(map);
//        PageInfo<WaterDayBean> pageInfo = new PageInfo<>();
//        return pageInfo;
        return res;
        
	}
	
	/**
	 * 错误返回 状态为400
	 * @return
	 */
	public Object error() {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 400);
		map.put("msg", "error");
		String result = JSON.toJSONString(map);
		return result;
	}
	
	/**
	 * 未知错误 状态为222
	 * @return
	 */
	public Object unkownError() {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 222);
		map.put("msg", "unkown error");
		String result = JSON.toJSONString(map);
		return result;
	}

}
