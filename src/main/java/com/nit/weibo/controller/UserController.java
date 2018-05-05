package com.nit.weibo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nit.weibo.dto.AjaxMsgDto;
import com.nit.weibo.dto.DataTable4DisplayDto;
import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.model.User;
import com.nit.weibo.service.IUserService;

@Controller
@RequestMapping("/wb_user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private IUserService userService;

	/**
	 * @author 刘宽
	 * @time 2018年1月12日 下午12:02:24
	 * @Description 会员详情列表
	 * @param @param dataTableDto
	 * @param @return
	 * @return DataTable4DisplayDto
	 * @throws 
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public DataTable4DisplayDto getInfoDataTable(DataTableDto dataTableDto, Integer type){
		DataTable4DisplayDto result = null;
		try {
			Integer count = this.userService.getInfoCount(dataTableDto.getSearch(), type);
			List<User> data = this.userService.getInfoDataTable(dataTableDto, type);
			result=new DataTable4DisplayDto(dataTableDto.getDraw(), count, count, data);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @author 刘宽
	 * @time 2018年1月16日 下午9:24:18
	 * @Description 修改积分
	 * @param @param userId
	 * @param @param openid
	 * @param @param jifen
	 * @param @return
	 * @return AjaxMsgDto
	 * @throws 
	 */
	@RequestMapping(value = "/editJifen", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto editJifen(Integer userId, String openid,  String jifen) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = userService.editJifen(userId, openid, jifen);
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
	
	/**
	 * @author 刘宽
	 * @time 2018年1月16日 下午9:24:41
	 * @Description 修改会员到期时间
	 * @param @param userId
	 * @param @param openid
	 * @param @param riqi
	 * @param @return
	 * @return AjaxMsgDto
	 * @throws 
	 */
	@RequestMapping(value = "/editHuiyuan", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto editHuiyuan(Integer userId, String openid,  String riqi) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = userService.editHuiyuan(userId, openid, riqi);
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
