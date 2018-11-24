package com.ljf.datasource;

import java.util.TimerTask;

/**
 * 
 * @ClassName:  ClearIdleTimerTask   
 * @Description:TODO(定时器任务ClearIdleTimerTask用于定时清除空闲的数据源)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午10:39:04   
 *
 */
public class ClearIdleTimerTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DDSHolder.instance().clearIdleDDS();
	}

}
