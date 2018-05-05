package com.nit.weibo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nit.weibo.model.User;
import com.nit.weibo.model.UserKey;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	Integer getCount();

	Integer getCmoney(Integer userId);

	Integer updateMoney(Integer num,Integer userId);

	Integer getCount2(String search);
	
	Integer getCountY();

	Integer getCount2Y(String search);
	
	Integer getCountN();

	Integer getCount2N(String search);

	List<User> getDataTable();

	List<User> getDataTable2(String s);
	
	List<User> getDataTableY();

	List<User> getDataTable2Y(String s);
	
	List<User> getDataTableN();

	List<User> getDataTable2N(String s);

}