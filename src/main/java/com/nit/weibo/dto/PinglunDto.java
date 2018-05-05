package com.nit.weibo.dto;

import java.util.List;

public class PinglunDto {
	
	private Integer contentKeyId;

    private String keyword;
    
    private String contentId;
    
    private List<String> content;
    
    private Integer contentFuSwitch;
    
    private String contentFuId;
    
    private List<String> contentFu;
	
	public PinglunDto(){
		super();
	}
	
	public PinglunDto(Integer contentKeyId, String keyword, String contentId, List<String> content, Integer contentFuSwitch, String contentFuId, List<String> contentFu){
		super();
		this.contentKeyId = contentKeyId;
		this.keyword = keyword;
		this.content = content;
		this.contentFuSwitch = contentFuSwitch;
		this.contentFu = contentFu;
	}

	public Integer getContentKeyId() {
		return contentKeyId;
	}

	public void setContentKeyId(Integer contentKeyId) {
		this.contentKeyId = contentKeyId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public Integer getContentFuSwitch() {
		return contentFuSwitch;
	}

	public void setContentFuSwitch(Integer contentFuSwitch) {
		this.contentFuSwitch = contentFuSwitch;
	}

	public List<String> getContentFu() {
		return contentFu;
	}

	public void setContentFu(List<String> contentFu) {
		this.contentFu = contentFu;
	}
	
	public String getContentFuId() {
		return contentFuId;
	}

	public void setContentFuId(String contentFuId) {
		this.contentFuId = contentFuId;
	}
}
