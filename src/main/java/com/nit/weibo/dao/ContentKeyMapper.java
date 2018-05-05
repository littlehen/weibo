package com.nit.weibo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nit.weibo.dto.PinglunDto;
import com.nit.weibo.dto.ShenheDto;
import com.nit.weibo.model.ContentKey;
import com.nit.weibo.model.ContentKeyWithBLOBs;

@Repository
public interface ContentKeyMapper {
    int deleteByPrimaryKey(Integer contentKeyId);

    int insert(ContentKeyWithBLOBs record);

    int insertSelective(ContentKeyWithBLOBs record);

    ContentKeyWithBLOBs selectByPrimaryKey(Integer contentKeyId);

    int updateByPrimaryKeySelective(ContentKeyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ContentKeyWithBLOBs record);

    int updateByPrimaryKey(ContentKey record);

	Integer getCount();

	Integer getZNum(Integer contentKeyId);

	Integer getCount2(String search);

	List<ShenheDto> getDataTable();

	List<ShenheDto> getDataTable2(String search);

	Integer getzCount(Integer userId);

	List<ContentKeyWithBLOBs> getzDataTable(Integer userId);

	Integer getplCount(Integer userId);

	List<PinglunDto> getplDataTable(Integer userId);
	
	Integer getgnCount(Integer userId);
}