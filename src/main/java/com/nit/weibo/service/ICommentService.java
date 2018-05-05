package com.nit.weibo.service;

import com.nit.weibo.dto.ContentKeyDto;
import com.nit.weibo.dto.ContentSuccessDto;

public interface ICommentService {

    public boolean saveWBAccount(Integer userId,String username, String password, String drive,Integer flag) throws Exception;

    public boolean saveContent(Integer contentId,Integer userId, String content, String drive,Integer flag) throws Exception;

    public ContentSuccessDto saveContentKey(ContentKeyDto contentKeyDto, String drive, Integer flag) throws Exception;
}
