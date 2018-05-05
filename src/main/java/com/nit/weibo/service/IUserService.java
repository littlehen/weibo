package com.nit.weibo.service;

import java.util.List;

import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.model.User;

public interface IUserService {

	public Integer getInfoCount(String search, Integer type) throws Exception;
	
	public List<User> getInfoDataTable(DataTableDto dataTableDto, Integer type) throws Exception;

	public Object editJifen(Integer userId, String jifen, String jifen2) throws Exception;

	public Object editHuiyuan(Integer userId, String riqi, String riqi2) throws Exception;

}
