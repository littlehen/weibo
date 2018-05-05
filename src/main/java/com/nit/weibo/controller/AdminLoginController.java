package com.nit.weibo.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nit.weibo.dto.AjaxMsgDto;
import com.nit.weibo.service.IAdminLoginService;

@Controller
@RequestMapping("/wb_admin")
public class AdminLoginController {
	private static Logger logger = Logger.getLogger(AdminLoginController.class);

	@Resource
	private IAdminLoginService adminLoginService;
	
	/**
	 * @Description: 管理员登录
	 * @param @param username
	 * @param @param password
	 * @param @param drive
	 * @param @return  
	 * @return AjaxMsgDto 
	 * @author 刘宽
	 * @date 2017年4月6日 下午7:01:09 
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto login(String username, String password, String drive) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = adminLoginService.login(username,password,drive);
			if(info != null){				
				ajaxMsgDto.setData(info);
			}
			else;
			logger.info(ajaxMsgDto.toString());
		} catch (Exception e) {
			e.printStackTrace();
			ajaxMsgDto.setIsSuccess(false);
		}
		return ajaxMsgDto;
	}

}
