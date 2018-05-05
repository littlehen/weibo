package com.nit.weibo.dto;

public class PayDto {

	public Integer id;

	public Integer userId;
    
	public String localCode;

	public String wechatPayCode;

	public Integer type;

	public String time;
    
	public String money;

	public String body;
    
	public String cname;

    public PayDto(){
		super();
	}
    
    public PayDto(Integer id, Integer userId, String localCode, String wechatPayCode, Integer type, String time, String money, String body, String cname){
		super();
		this.id = id;
		this.userId = userId;
		this.localCode = localCode;
		this.wechatPayCode = wechatPayCode;
		this.type = type;
		this.time = time;
		this.money = money;
		this.body = body;
		this.cname = cname;
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public String getWechatPayCode() {
		return wechatPayCode;
	}

	public void setWechatPayCode(String wechatPayCode) {
		this.wechatPayCode = wechatPayCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
}
