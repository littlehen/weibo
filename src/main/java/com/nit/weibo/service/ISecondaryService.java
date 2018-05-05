package com.nit.weibo.service;

import com.nit.weibo.dto.ContentSuccessDto;

public interface ISecondaryService {
    public ContentSuccessDto saveSecondaryAccount(Integer userId, String username, String password, String drive, Integer flag, Integer weiboId) throws Exception;

}
