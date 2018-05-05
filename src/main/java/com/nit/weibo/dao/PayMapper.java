package com.nit.weibo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nit.weibo.dto.PayDto;
import com.nit.weibo.dto.TypeSDto;
import com.nit.weibo.model.Pay;
import com.nit.weibo.model.PayWithBLOBs;

@Repository
public interface PayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayWithBLOBs record);

    int insertSelective(PayWithBLOBs record);

    PayWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PayWithBLOBs record);

    int updateByPrimaryKey(Pay record);

	Integer getCount(TypeSDto r);

	Integer getCount2(TypeSDto r);

	List<PayDto> getDataTable(TypeSDto r);

	List<PayDto> getDataTable2(TypeSDto r);
}