package com.sd.model;

public class TableSearch {
	private String value;// 搜索框内容
	private boolean regex;//是否支持正则表达式
	@Override
	public String toString() {
		return "TableSearch [value=" + value + ", regex=" + regex + "]";
	}
	public TableSearch() {
		super();
	}
	public TableSearch(String value, boolean regex) {
		super();
		this.value = value;
		this.regex = regex;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isRegex() {
		return regex;
	}
	public void setRegex(boolean regex) {
		this.regex = regex;
	}

}
