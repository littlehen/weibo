package com.nit.weibo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.nit.weibo.dao.PayMapper;
import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.dto.PayDto;
import com.nit.weibo.dto.TypeSDto;
import com.nit.weibo.service.IPayService;

@Service
public class PayService implements IPayService {

	@Resource
	private PayMapper payDao;

	@Override
	public Integer getInfoCount(String search, Integer type) throws Exception {
		if((type == 1) || (type == 2));
		else 
			type = null;
		
		Integer resultCount = 0;
		if(search=="")
		{
			TypeSDto r = new TypeSDto();
			r.setType(type);
			resultCount = this.payDao.getCount(r);
		}
		else
		{
			TypeSDto r = new TypeSDto();
			r.setType(type);
			r.setSearch(search);
			resultCount = this.payDao.getCount2(r);
		}
		return resultCount;
	}

	@Override
	public List<PayDto> getInfoDataTable(DataTableDto dataTableDto, Integer type) throws Exception {
		if((type == 1) || (type == 2));
		else 
			type = null;
		
		String search=dataTableDto.getSearch();
		Integer page = 0;
		if(dataTableDto.length!=-1) {
			dataTableDto.start = dataTableDto.start == null ? 1 : dataTableDto.start;
			dataTableDto.length = dataTableDto.length == null ? 10 : dataTableDto.length;
			page = (dataTableDto.start / dataTableDto.length) + 1; //第几页
			PageHelper.startPage(page, dataTableDto.length);
		}
		List<PayDto> list=null;
		if(search==""){
			TypeSDto r = new TypeSDto();
			r.setType(type);
			list=this.payDao.getDataTable(r);
		}
		else{
			TypeSDto r = new TypeSDto();
			r.setType(type);
			r.setSearch(search);
			list=this.payDao.getDataTable2(r);
		}
		return list;
	}
}
