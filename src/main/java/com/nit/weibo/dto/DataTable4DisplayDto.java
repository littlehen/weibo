package com.nit.weibo.dto;

import java.io.Serializable;

/**
 * @description dataTable展示
 */
public class DataTable4DisplayDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private Object data;

	public DataTable4DisplayDto() {
		super();
	}

	public DataTable4DisplayDto(Integer draw, Integer recordsTotal, Integer recordsFiltered, Object data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataTable4DisplayDto [draw=" + draw + ", recordsTotal=" + recordsTotal + ", recordsFiltered="
				+ recordsFiltered + ", data=" + data + "]";
	}
	
}
