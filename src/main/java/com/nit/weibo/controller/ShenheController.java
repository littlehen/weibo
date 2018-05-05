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
import com.nit.weibo.dto.FunctionsDto;
import com.nit.weibo.dto.PinglunDto;
import com.nit.weibo.dto.ShenheDto;
import com.nit.weibo.model.ContentKeyWithBLOBs;
import com.nit.weibo.model.Weibo;
import com.nit.weibo.service.IShenheService;

@Controller
@RequestMapping("/wb_shenhe")
public class ShenheController {
	private static Logger logger = Logger.getLogger(ShenheController.class);

	@Resource
	private IShenheService shenheService;
	
	/**
	 * @author 刘宽
	 * @time 2018年1月18日 下午12:30:57
	 * @Description 展示审核信息
	 * @param @param dataTableDto
	 * @param @return
	 * @return DataTable4DisplayDto
	 * @throws 
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public DataTable4DisplayDto getInfoDataTable(DataTableDto dataTableDto){
		DataTable4DisplayDto result = null;
		try {
			Integer count = this.shenheService.getInfoCount(dataTableDto.getSearch());
			List<ShenheDto> data = this.shenheService.getInfoDataTable(dataTableDto);
			result=new DataTable4DisplayDto(dataTableDto.getDraw(), count, count, data);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @author 刘宽
	 * @time 2018年1月18日 下午3:25:45
	 * @Description 微博账号审核列表
	 * @param @param dataTableDto
	 * @param @param userId
	 * @param @return
	 * @return DataTable4DisplayDto
	 * @throws 
	 */
	@RequestMapping(value = "/getwb", method = RequestMethod.POST)
	@ResponseBody
	public DataTable4DisplayDto getwbInfoDataTable(DataTableDto dataTableDto, Integer userId){
		DataTable4DisplayDto result = null;
		try {
			Integer count = this.shenheService.getwbInfoCount(userId);
			List<Weibo> data = this.shenheService.getwbInfoDataTable(dataTableDto, userId);
			result=new DataTable4DisplayDto(dataTableDto.getDraw(), count, count, data);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @author 刘宽
	 * @time 2018年1月18日 下午3:25:57
	 * @Description 微博主账号
	 * @param @param userId
	 * @param @return
	 * @return AjaxMsgDto
	 * @throws 
	 */
	@RequestMapping(value = "/getwbmain", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto getwbmain(Integer userId) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = shenheService.getwbmain(userId);
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
	 * @time 2018年1月18日 下午6:39:14
	 * @Description 微博账号审核
	 * @param @param id
	 * @param @param status
	 * @param @return
	 * @return AjaxMsgDto
	 * @throws 
	 */
	@RequestMapping(value = "/getwbShenhe", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto getwbShenhe(Integer id, Integer status) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = shenheService.getwbShenhe(id, status);
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
	 * @time 2018年1月18日 下午7:00:25
	 * @Description 赞审核列表
	 * @param @param dataTableDto
	 * @param @param userId
	 * @param @return
	 * @return DataTable4DisplayDto
	 * @throws 
	 */
	@RequestMapping(value = "/getz", method = RequestMethod.POST)
	@ResponseBody
	public DataTable4DisplayDto getzInfoDataTable(DataTableDto dataTableDto, Integer userId){
		DataTable4DisplayDto result = null;
		try {
			Integer count = this.shenheService.getzInfoCount(userId);
			List<ContentKeyWithBLOBs> data = this.shenheService.getzInfoDataTable(dataTableDto, userId);
			result=new DataTable4DisplayDto(dataTableDto.getDraw(), count, count, data);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @author 刘宽
	 * @time 2018年1月18日 下午7:06:00
	 * @Description 赞审核
	 * @param @param id
	 * @param @param status
	 * @param @return
	 * @return AjaxMsgDto
	 * @throws 
	 */
	@RequestMapping(value = "/getzShenhe", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto getzShenhe(Integer id, Integer status) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = shenheService.getzShenhe(id, status);
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
	 * @time 2018年1月18日 下午7:18:37
	 * @Description 评论审核列表
	 * @param @param dataTableDto
	 * @param @param userId
	 * @param @return
	 * @return DataTable4DisplayDto
	 * @throws 
	 */
	@RequestMapping(value = "/getpl", method = RequestMethod.POST)
	@ResponseBody
	public DataTable4DisplayDto getplInfoDataTable(DataTableDto dataTableDto, Integer userId){
		DataTable4DisplayDto result = null;
		try {
			Integer count = this.shenheService.getplInfoCount(userId);
			List<PinglunDto> data = this.shenheService.getplInfoDataTable(dataTableDto, userId);
			result=new DataTable4DisplayDto(dataTableDto.getDraw(), count, count, data);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @author 刘宽
	 * @time 2018年1月18日 下午7:23:34
	 * @Description 评论审核
	 * @param @param id
	 * @param @param status
	 * @param @return
	 * @return AjaxMsgDto
	 * @throws 
	 */
	@RequestMapping(value = "/getplShenhe", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto getplShenhe(Integer id, Integer status) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = shenheService.getplShenhe(id, status);
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
	 * 
	 * @author 吴佶津  
	 * @date 2018年5月2日    
	 * @Description 审核功能设置
	 * @param dataTableDto
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getgn", method = RequestMethod.POST)
	@ResponseBody
	public DataTable4DisplayDto getgnInfoDataTable(DataTableDto dataTableDto, Integer userId){
		DataTable4DisplayDto result = null;
		try {
			Integer count = this.shenheService.getgnInfoCount(userId);
			List<FunctionsDto> data = this.shenheService.getgnInfoDataTable(dataTableDto, userId);
			result=new DataTable4DisplayDto(dataTableDto.getDraw(), count, count, data);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @author 吴佶津  
	 * @date 2018年5月2日    
	 * @Description 功能设置
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/getgnShenhe", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsgDto getgnShenhe(Integer id, Integer status) {
		AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
		try {
			ajaxMsgDto.setIsSuccess(true);
			Object info = shenheService.getgnShenhe(id, status);
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
