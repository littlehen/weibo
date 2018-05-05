package com.nit.weibo.dto;

import java.io.Serializable;

/**
 * @description dataTable参数
 */
public class DataTableDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Integer draw;
	public Integer start;
	public Integer length;
	public String search;
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
