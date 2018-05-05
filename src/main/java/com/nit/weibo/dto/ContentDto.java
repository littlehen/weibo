package com.nit.weibo.dto;

import com.nit.weibo.model.Content;

public class ContentDto {
    private Integer contentId;

    private Integer userId;

    private String content;

    public ContentDto(){};
    public ContentDto(Integer userId,String content){
        this.userId=userId;
        this.content=content;
    }

    public ContentDto(Integer contentId,Integer userId,String content){
        this.userId=userId;
        this.contentId=contentId;
        this.content=content;
    }

    public Content toModel(){
        Content content = new Content();
        content.setUserId(this.getUserId());
        content.setContentId(this.getContentId());
        content.setContent(this.getContent());
        return content;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
