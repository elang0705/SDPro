package com.sd.model;

public class TableColum {
	private String data;//数据库对应字段
	private String title;//导出excel中使用的列名称
	private boolean orderable;//是否支持排序
	private boolean searchable;//是否支持搜索
	private int[] aTargets;//列索引	
	private TableSearch search;
	private boolean bvisible;//是否显示
	public int[] getaTargets() {
		return aTargets;
	}
	public void setaTargets(int[] aTargets) {
		this.aTargets = aTargets;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public boolean isOrderable() {
		return orderable;
	}
	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}
	public boolean isSearchable() {
		return searchable;
	}
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
	public TableSearch getSearch() {
		return search;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSearch(TableSearch search) {
		this.search = search;
	}
	public boolean isBvisible() {
		return bvisible;
	}
	public void setBvisible(boolean bvisible) {
		this.bvisible = bvisible;
	}
	public TableColum(String data, String title, boolean orderable,
			boolean searchable, TableSearch search, boolean bvisible,int[] aTargets) {
		super();
		this.data = data;
		this.title = title;
		this.orderable = orderable;
		this.searchable = searchable;
		this.search = search;
		this.bvisible = bvisible;
		this.aTargets = aTargets;
	}
	public TableColum() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TableColum [data=" + data + ", title=" + title + ", orderable="
				+ orderable + ", searchable=" + searchable + ", search="
				+ search + ", bvisible=" + bvisible + ",aTargets="+aTargets+"]";
	}

}
