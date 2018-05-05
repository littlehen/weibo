package com.nit.weibo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nit.weibo.dto.AdminLoginDto;
import com.nit.weibo.model.Admin;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    List<?> selectLogin(String username, String password);

	AdminLoginDto pro_admin_login(@Param("id")Integer id, @Param("userDevice")String drive, @Param("loginIP")String ipAddress, @Param("sessionId")String sessionId);

}