package com.nit.weibo.dto;

import java.io.Serializable;

public class AjaxMsgDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Boolean isSuccess;
	private Object data;
	
	public AjaxMsgDto() {
		super();
	}
	
	public AjaxMsgDto(Boolean isSuccess, Object data) {
		super();
		this.isSuccess = isSuccess;
		this.data = data;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
