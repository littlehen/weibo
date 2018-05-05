package com.nit.weibo.dao;

import org.springframework.stereotype.Repository;

import com.nit.weibo.model.Card;

@Repository
public interface CardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}