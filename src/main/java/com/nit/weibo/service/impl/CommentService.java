package com.nit.weibo.service.impl;

import com.nit.weibo.dao.ContentKeyMapper;
import com.nit.weibo.dao.ContentMapper;
import com.nit.weibo.dao.UserMapper;
import com.nit.weibo.dao.WeiboMapper;
import com.nit.weibo.dto.ContentDto;
import com.nit.weibo.dto.ContentKeyDto;
import com.nit.weibo.dto.ContentSuccessDto;
import com.nit.weibo.dto.WeiboDto;
import com.nit.weibo.model.Content;
import com.nit.weibo.model.ContentKeyWithBLOBs;
import com.nit.weibo.model.Weibo;
import com.nit.weibo.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentService implements ICommentService{

    @Resource
    private WeiboMapper weiboDao;
    @Resource
    private ContentMapper contentDao;
    @Resource
    private ContentKeyMapper contentKeyDao;
    @Resource
    private UserMapper userDao;


    @Override
    public boolean saveWBAccount(Integer userId,String username, String password, String drive,Integer flag) throws Exception{
        boolean isSave=false;
        if(0==flag){
            WeiboDto weiboDto = new WeiboDto(userId,username,password,1,0,0);
            Weibo weibo = weiboDto.toModel();
            weiboDao.insert(weibo);
            //System.out.println(weibo.getWeiboId());
            if(weibo.getWeiboId()>0){
                isSave=true;
            }
        }else if(1==flag){
            WeiboDto weiboDto = new WeiboDto(userId,username,password,0);
            Weibo weibo = weiboDto.toModel();
            weiboDao.updateByUserId(weibo);
            //System.out.println(weibo.getWeiboId());
            if(weibo.getWeiboId()>0){
                isSave=true;
            }
        }
        return isSave;
    }

    @Override
    public boolean saveContent(Integer contentId,Integer userId, String content, String drive,Integer flag) throws Exception{
        boolean isSave=false;
        if(0==flag){
            ContentDto contentDto = new ContentDto(userId,content);
            Content content1 = contentDto.toModel();
            contentDao.insert(content1);
            if(content1.getContentId()>0){
                isSave=true;
            }
        }else if(1==flag){
            ContentDto contentDto = new ContentDto(contentId,userId,content);
            Content content1 = contentDto.toModel();
            contentDao.updateByPrimaryKey(content1);
            if(content1.getContentId()>0){
                isSave=true;
            }
        }else if(2==flag){
            contentDao.deleteByPrimaryKey(contentId);
            isSave=true;
        }
        return isSave;
    }
    @Override
    public ContentSuccessDto saveContentKey(ContentKeyDto contentKeyDto, String drive, Integer flag) throws Exception{
        ContentSuccessDto contentSuccessDto = new ContentSuccessDto();
        contentSuccessDto.setSave(false);
        int res=-1;
        if(flag==0||flag==1){
            //ystem.out.println(contentKeyDto.getUserId());
            Integer cmoney = userDao.getCmoney(contentKeyDto.getUserId());
            if(cmoney<100){
                contentSuccessDto.setErrorMsg("cmoney lack");
            }else{
                userDao.updateMoney(100,contentKeyDto.getUserId());
                contentSuccessDto.setSave(true);
            }
        }
        if(0==flag){
            contentKeyDto.setIsFinish(0);
            contentKeyDto.setIsZanFinish(0);
            ContentKeyWithBLOBs contentKeyWithBLOBs = contentKeyDto.toModel();
            contentKeyDao.insert(contentKeyWithBLOBs);
            if(contentKeyWithBLOBs.getContentKeyId()<0){
                contentSuccessDto.setErrorMsg("insert fail");
                res=0;
            }
        }else if(1==flag){
            contentKeyDto.setIsFinish(0);
            Integer ZNum = contentKeyDao.getZNum(contentKeyDto.getContentKeyId());
            contentKeyDto.setIsZanFinish(1);
            if(ZNum!=contentKeyDto.getZanNumber()){
                contentKeyDto.setIsZanFinish(0);
            }
            ContentKeyWithBLOBs contentKeyWithBLOBs = contentKeyDto.toModel();
            contentKeyDao.updateByPrimaryKey(contentKeyWithBLOBs);
            if(contentKeyWithBLOBs.getContentKeyId()<0){
                contentSuccessDto.setErrorMsg("update fail");
                res=0;
            }
        }else if(2==flag){
            contentKeyDao.deleteByPrimaryKey(contentKeyDto.getContentKeyId());
            contentSuccessDto.setSave(true);
        }
        if(res!=0){
            contentSuccessDto.setSave(true);
        }
        return contentSuccessDto;
    }
}
