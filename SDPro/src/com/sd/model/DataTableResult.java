package com.sd.model;

import net.sf.json.JSONArray;
/**
 * 返回DataTable实体
 * @author elang
 *
 */
public class DataTableResult {
	private Integer draw;
	private Integer recordsTotal;//过滤之前的总数据量
	private Integer recordsFiltered;//过滤之后的总数据量
	private JSONArray data;
	private String error;//错误信息
	public DataTableResult() {
		super();
	}
	public DataTableResult(Integer draw, Integer recordsTotal,
			Integer recordsFiltered, JSONArray data, String error) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
		this.error = error;
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
	public JSONArray getData() {
		return data;
	}
	public void setData(JSONArray data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "DataTableResult [draw=" + draw + ", recordsTotal="
				+ recordsTotal + ", recordsFiltered=" + recordsFiltered
				+ ", data=" + data + ", error=" + error + "]";
	}
}
