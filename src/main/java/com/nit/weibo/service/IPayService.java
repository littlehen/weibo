package com.nit.weibo.service;

import java.util.List;

import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.dto.PayDto;

public interface IPayService {

	public Integer getInfoCount(String search, Integer type) throws Exception;

	public List<PayDto> getInfoDataTable(DataTableDto dataTableDto, Integer type) throws Exception;

}
