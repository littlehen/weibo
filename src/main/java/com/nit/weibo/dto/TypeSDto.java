package com.nit.weibo.dto;

public class TypeSDto {
	public String search;
	
	public Integer type;

	public TypeSDto(){
		super();
	}
	
	public TypeSDto(String search, Integer type){
		super();
		this.search = search;
		this.type = type;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
