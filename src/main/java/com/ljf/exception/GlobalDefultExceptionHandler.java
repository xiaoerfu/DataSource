package com.ljf.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljf.utils.JsonPackUtils;

/**
 * 全局异常捕获
 * 
 * @ClassName: GlobalDefultExceptionHandler
 * @Description:TODO(捕捉全局变量值)
 * @author: 铭汉科技—LJF
 * @date: 2018年8月15日 上午11:01:59
 *
 */
@ControllerAdvice
public class GlobalDefultExceptionHandler {

	JsonPackUtils jsonPackUtils = new JsonPackUtils();

	protected org.slf4j.Logger logger;

	public GlobalDefultExceptionHandler() {
		logger = LoggerFactory.getLogger(getClass());
	}

	// 声明要捕获的异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object defultExcepitonHandler(HttpServletRequest request, Exception e) {
		e.printStackTrace();
		if (e instanceof BusinessException) {
			System.out.println(this.getClass() + "业务异常：" + e.getMessage());
			BusinessException businessException = (BusinessException) e;
			return businessException.getCode() + businessException.getMessage();
		} else if (e instanceof DataBaseException) {
			System.out.println(this.getClass() + "数据库异常： " + e.getMessage());
			DataBaseException dataBaseException = (DataBaseException) e;
			return dataBaseException.getCode() + dataBaseException.getMessage();
		}
		// 未知错误
		return jsonPackUtils.unkownError();
	}

	@ExceptionHandler({ SQLException.class })
	public String databaseError(Exception exception) {
		logger.error("Request raised " + exception.getClass().getSimpleName());
		return "Global_databaseError";
	}
}
