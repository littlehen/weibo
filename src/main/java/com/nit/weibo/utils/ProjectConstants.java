package com.nit.weibo.utils;

public final class ProjectConstants {
	
	// 返回处理结果
	public final static Boolean Success = true;// 成功
	public final static Boolean Failure = false;// 失败
	public final static String sSuccess = "Success";// 成功
	public final static String sFailure = "Failure";// 失败
	public final static String ErrorTips = "对不起，系统错误!";// 异常
	public final static String FailureTips_name = "对不起，用户名不存在!";// 账号不存在
	public final static String FailureTips_pwd = "对不起，密码错误，请重新输入!";// 密码错误

	// 网站域名配置
	public final static String WebUrl = "http://volunteer.dopan.net/weibo";

	// 设备类型
	public final static String DeviceType_Web = "web";

	// 跨域Session验证失败信息，WEB端使用sessionTimeOut
	public final static String SessionCheck_TimeOut = "sessionTimeOut";
	
	// 跨域Token验证失败信息，WEB端使用sessionTimeOut
	public final static String TokenCheck_TimeOut = "{\"errcode\":40001,\"errmsg\":\"token timeOut\"}";
	
	// 登陆信息错误        想跳过验证,没门(必须填写符合要求的设备类型)
	public final static String LoginError = "{\"errcode\":10001,\"errmsg\":\"No Permission\"}";
	
}
