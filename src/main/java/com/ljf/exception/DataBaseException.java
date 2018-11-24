package com.ljf.exception;

import java.sql.SQLException;

public class DataBaseException extends SQLException{
	
private static final long serialVersionUID = 1L;
	
	private Integer code;  //错误码
 
	public DataBaseException() {}
	
	public DataBaseException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	
	public Integer getCode() {
		return code;
	}
 
	public void setCode(Integer code) {
		this.code = code;
	}

}
