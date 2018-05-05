package com.nit.weibo.service.impl;

import com.nit.weibo.dao.ContentMapper;
import com.nit.weibo.dao.UserMapper;
import com.nit.weibo.dao.WeiboMapper;
import com.nit.weibo.dto.ContentDto;
import com.nit.weibo.dto.ContentSuccessDto;
import com.nit.weibo.dto.WeiboDto;
import com.nit.weibo.model.Content;
import com.nit.weibo.model.Weibo;
import com.nit.weibo.service.ISecondaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SecondaryService implements ISecondaryService{

    @Resource
    private WeiboMapper weiboDao;
    @Resource
    private UserMapper userDao;

    @Override
    public ContentSuccessDto saveSecondaryAccount(Integer userId, String username, String password, String drive, Integer flag, Integer weiboId) throws Exception{
        ContentSuccessDto contentSuccessDto = new ContentSuccessDto();
        contentSuccessDto.setSave(false);
        if(flag==0){
            Integer cmoney = userDao.getCmoney(userId);
            if(cmoney<20){
                contentSuccessDto.setErrorMsg("cmoney lack");
            }else{
                userDao.updateMoney(20,userId);
                contentSuccessDto.setSave(true);
            }
        }

        if(0==flag){
            WeiboDto weiboDto = new WeiboDto(userId,username,password,2,0,0);
            Weibo weibo = weiboDto.toModel();
            weiboDao.insert(weibo);
            //System.out.println(weibo.getWeiboId());
            if(weibo.getWeiboId()<0){
                contentSuccessDto.setSave(false);
                contentSuccessDto.setErrorMsg("insert error");
            }
        }else if(1==flag){
            WeiboDto weiboDto = new WeiboDto(weiboId,userId,username,password,2,0,0);
            Weibo weibo = weiboDto.toModel();
            weiboDao.updateByPrimaryKey(weibo);
            if(weibo.getWeiboId()<0){
                contentSuccessDto.setSave(false);
                contentSuccessDto.setErrorMsg("update error");
            };
        }else {
            weiboDao.deleteByPrimaryKey(weiboId);
            contentSuccessDto.setSave(true);
        }
        return contentSuccessDto;
    }

}
