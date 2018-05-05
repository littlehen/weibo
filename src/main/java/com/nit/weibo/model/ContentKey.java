package com.nit.weibo.model;

public class ContentKey {
    private Integer contentKeyId;

    private Integer userId;

    private String keyword;

    private Integer contentFu;

    private Integer isFinish;

    private Integer zanNumber;

    private Integer isZanFinish;

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
}