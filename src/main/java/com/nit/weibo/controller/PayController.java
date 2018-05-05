package com.nit.weibo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nit.weibo.dto.DataTable4DisplayDto;
import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.dto.PayDto;
import com.nit.weibo.service.IPayService;

@Controller
@RequestMapping("/wb_pay")
public class PayController {
	private static Logger logger = Logger.getLogger(PayController.class);

	@Resource
	private IPayService payService;
	
	/**
	 * @author 刘宽
	 * @time 2018年1月16日 下午11:12:41
	 * @Description 充值展示
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
			Integer count = this.payService.getInfoCount(dataTableDto.getSearch(), type);
			List<PayDto> data = this.payService.getInfoDataTable(dataTableDto, type);
			result=new DataTable4DisplayDto(dataTableDto.getDraw(), count, count, data);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
