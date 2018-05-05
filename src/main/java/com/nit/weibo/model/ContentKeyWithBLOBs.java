package com.nit.weibo.model;

public class ContentKeyWithBLOBs extends ContentKey {
    private String contentId;

    private String contentFuId;

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