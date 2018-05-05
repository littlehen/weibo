package com.nit.weibo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.nit.weibo.dao.UserMapper;
import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.model.User;
import com.nit.weibo.service.IUserService;

@Service
public class UserService implements IUserService {

	@Resource
	private UserMapper userDao;

	@Override
	public Integer getInfoCount(String search, Integer type) throws Exception {
		Integer resultCount = 0;
		if(type == 0)
		{
			if(search=="")
				resultCount = this.userDao.getCount();
			else
				resultCount = this.userDao.getCount2(search);
		}
		else if(type == 1)
		{
			if(search=="")
				resultCount = this.userDao.getCountY();
			else
				resultCount = this.userDao.getCount2Y(search);
		}
		else if(type == 2)
		{
			if(search=="")
				resultCount = this.userDao.getCountN();
			else
				resultCount = this.userDao.getCount2N(search);
		}
		else;
		return resultCount;
	}
	
	@Override
	public List<User> getInfoDataTable(DataTableDto dataTableDto, Integer type) throws Exception {
		String s=dataTableDto.getSearch();
		Integer page = 0;
		if(dataTableDto.length!=-1) {
			dataTableDto.start = dataTableDto.start == null ? 1 : dataTableDto.start;
			dataTableDto.length = dataTableDto.length == null ? 10 : dataTableDto.length;
			page = (dataTableDto.start / dataTableDto.length) + 1; //第几页
			PageHelper.startPage(page, dataTableDto.length);
		}
		List<User> list=null;
		if(type == 0)
		{
			if(s==""){
				list=this.userDao.getDataTable();
			}
			else{
				list=this.userDao.getDataTable2(s);
			}
		}
		else if(type == 1)
		{
			if(s==""){
				list=this.userDao.getDataTableY();
			}
			else{
				list=this.userDao.getDataTable2Y(s);
			}
		}
		else if(type ==2)
		{
			if(s==""){
				list=this.userDao.getDataTableN();
			}
			else{
				list=this.userDao.getDataTable2N(s);
			}
		}
		else;
		return list;
	}

	@Override
	public Object editJifen(Integer userId, String openid, String jifen) throws Exception {
		User record = new User();
		record.setUserId(userId);
		record.setOpenid(openid);
		record.setCmoney(jifen);
		this.userDao.updateByPrimaryKeySelective(record);
		return 1;
	}

	@Override
	public Object editHuiyuan(Integer userId, String openid, String riqi) throws Exception {
		//转日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = sdf.parse(riqi); 
	    
		User record = new User();
		record.setUserId(userId);
		record.setOpenid(openid);
		record.setMember_endtime(date);
		this.userDao.updateByPrimaryKeySelective(record);
		return 1;
	}
	
}
