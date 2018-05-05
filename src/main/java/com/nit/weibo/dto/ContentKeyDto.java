package com.nit.weibo.dto;

import com.nit.weibo.model.ContentKeyWithBLOBs;

public class ContentKeyDto {

    private Integer contentKeyId;

    private Integer userId;

    private String keyword;

    private Integer contentFu;

    private String contentId;

    private String contentFuId;

    private Integer isFinish;

    private Integer zanNumber;

    private Integer isZanFinish;

    public ContentKeyDto(){};
    public ContentKeyDto(Integer contentKeyId,Integer userId,String keyword,Integer contentFu,String contentFuId,Integer isFinish,String contentId,Integer zanNumber,Integer isZanFinish){
        this.contentKeyId=contentKeyId;
        this.userId=userId;
        this.keyword=keyword;
        this.contentFu=contentFu;
        this.isFinish=isFinish;
        this.zanNumber=zanNumber;
        this.isZanFinish=isZanFinish;
        this.contentFuId=contentFuId;
        this.contentId=contentId;
    }

    public ContentKeyWithBLOBs toModel(){
        ContentKeyWithBLOBs contentKeyWithBLOBs=new ContentKeyWithBLOBs();
        contentKeyWithBLOBs.setContentKeyId(contentKeyId);
        contentKeyWithBLOBs.setContentFuId(contentFuId);
        contentKeyWithBLOBs.setContentFu(contentFu);
        contentKeyWithBLOBs.setContentId(contentId);
        contentKeyWithBLOBs.setIsFinish(isFinish);
        contentKeyWithBLOBs.setIsZanFinish(isZanFinish);
        contentKeyWithBLOBs.setKeyword(keyword);
        contentKeyWithBLOBs.setUserId(userId);
        contentKeyWithBLOBs.setZanNumber(zanNumber);
        return contentKeyWithBLOBs;
    }

    public Integer getContentKeyId() {
        return contentKeyId;
    }

    public void setContentKeyId(Integer contentKeyId) {
        this.contentKeyId = contentKeyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getContentFu() {
        return contentFu;
    }

    public void setContentFu(Integer contentFu) {
        this.contentFu = contentFu;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getZanNumber() {
        return zanNumber;
    }

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }

    public Integer getIsZanFinish() {
        return isZanFinish;
    }

    public void setIsZanFinish(Integer isZanFinish) {
        this.isZanFinish = isZanFinish;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
    }

    public String getContentFuId() {
        return contentFuId;
    }

    public void setContentFuId(String contentFuId) {
        this.contentFuId = contentFuId == null ? null : contentFuId.trim();
    }
}
