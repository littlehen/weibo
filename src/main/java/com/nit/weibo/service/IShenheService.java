package com.nit.weibo.service;

import java.util.List;

import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.dto.FunctionsDto;
import com.nit.weibo.dto.PinglunDto;
import com.nit.weibo.dto.ShenheDto;
import com.nit.weibo.model.ContentKeyWithBLOBs;
import com.nit.weibo.model.Weibo;

public interface IShenheService {

	public Integer getInfoCount(String search) throws Exception;

	public List<ShenheDto> getInfoDataTable(DataTableDto dataTableDto) throws Exception;

	public Integer getwbInfoCount(Integer userId) throws Exception;

	public List<Weibo> getwbInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception;

	public Weibo getwbmain(Integer userId) throws Exception;

	public Object getwbShenhe(Integer id, Integer status) throws Exception;

	public Integer getzInfoCount(Integer userId) throws Exception;

	public List<ContentKeyWithBLOBs> getzInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception;

	public Object getzShenhe(Integer id, Integer status) throws Exception;

	public Integer getplInfoCount(Integer userId) throws Exception;

	public List<PinglunDto> getplInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception;

	public Object getplShenhe(Integer id, Integer status) throws Exception;
	
	public Integer getgnInfoCount(Integer userId) throws Exception;
	
	public List<FunctionsDto> getgnInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception;
	
	public Object getgnShenhe(Integer id, Integer status) throws Exception;

}
