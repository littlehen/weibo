package com.nit.weibo.dto;

public class ShenheDto {

	public Integer userId;
	
	public String cname;
	
	public Integer weiboIsFinish;
	
	public Integer contentIsFinish;
	
	public Integer zanIsFinish;
	
	public Integer functionsIsFinish;
	
	public Integer getFunctionsIsFinish() {
		return functionsIsFinish;
	}

	public void setFunctionsIsFinish(Integer functionsIsFinish) {
		this.functionsIsFinish = functionsIsFinish;
	}

	public ShenheDto(){
		super();
	}
	
	public ShenheDto(Integer userId, String cname, Integer weiboIsFinish, Integer contentIsFinish, Integer zanIsFinish,Integer functionsIsFinish){
		super();
		this.userId = userId;
		this.cname = cname;
		this.weiboIsFinish = weiboIsFinish;
		this.contentIsFinish = contentIsFinish;
		this.zanIsFinish = zanIsFinish;
		this.functionsIsFinish = functionsIsFinish;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getWeiboIsFinish() {
		return weiboIsFinish;
	}

	public void setWeiboIsFinish(Integer weiboIsFinish) {
		this.weiboIsFinish = weiboIsFinish;
	}

	public Integer getContentIsFinish() {
		return contentIsFinish;
	}

	public void setContentIsFinish(Integer contentIsFinish) {
		this.contentIsFinish = contentIsFinish;
	}

	public Integer getZanIsFinish() {
		return zanIsFinish;
	}

	public void setZanIsFinish(Integer zanIsFinish) {
		this.zanIsFinish = zanIsFinish;
	}
}
