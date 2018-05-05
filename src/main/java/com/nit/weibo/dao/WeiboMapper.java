package com.nit.weibo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nit.weibo.dto.FunctionsDto;
import com.nit.weibo.model.Functions;
import com.nit.weibo.model.Weibo;

@Repository
public interface WeiboMapper {
    int deleteByPrimaryKey(Integer weiboId);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    Weibo selectByPrimaryKey(Integer weiboId);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKey(Weibo record);

    int updateByUserId(Weibo record);

	Weibo selectByUserId(Integer userId);

	Integer getCount(Integer userId);

	List<Weibo> getDataTable(Integer userId);

	Integer UpdateSelectByUserId(Integer userId);
	
	List<FunctionsDto> getgnDataTable(Integer userId);

	int updateByPrimaryKeyFunctions(Functions functions);
}