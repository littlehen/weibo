package com.nit.weibo.dao;

import org.springframework.stereotype.Repository;

import com.nit.weibo.model.Bill;

@Repository
public interface BillMapper {
    int deleteByPrimaryKey(Integer billId);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer billId);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}