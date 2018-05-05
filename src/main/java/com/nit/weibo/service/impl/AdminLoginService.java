package com.nit.weibo.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.nit.weibo.dao.AdminMapper;
import com.nit.weibo.dto.AdminLoginDto;
import com.nit.weibo.service.IAdminLoginService;
import com.nit.weibo.utils.EncryptionByMD5;
import com.nit.weibo.utils.HttpServletUtil;

@Service
public class AdminLoginService implements IAdminLoginService {

	@Resource
	private AdminMapper adminDao;
	
	@Resource
	private HttpServletUtil servletUtil;
	
	@Override
	public Object login(String username, String password, String drive) throws Exception {
		//获取登陆ip
		HttpServletRequest request = servletUtil.getRequest();
		String ipAddress =  request.getRemoteAddr();
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		AdminLoginDto xx = null;
		
		List<?> id = adminDao.selectLogin(username,EncryptionByMD5.encryption(password.getBytes()));		
		if(id.size()==0)
			return -1;
		else
		{
			xx = adminDao.pro_admin_login((Integer) id.get(0),drive,ipAddress,sessionId);
			return xx;
		}
		
	}
	
}
