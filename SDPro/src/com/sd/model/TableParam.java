package com.sd.model;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.events.StartDocument;

public class TableParam {
	private int start = 0;
	private int length = 0;
	private int draw;
	private TableSearch search;
	private List<TableOrder> orders;
	private List<TableColum> columns;
	private String[] searchParam;
	public TableParam() {
		super();
	}
	public TableParam(int start, int length, int draw, TableSearch search,
			List<TableOrder> orders, List<TableColum> colums,
			String[] searchParam) {
		super();
		this.start = start;
		this.length = length;
		this.draw = draw;
		this.search = search;
		this.orders = orders;
		this.columns = columns;
		this.searchParam = searchParam;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public TableSearch getSearch() {
		return search;
	}
	public void setSearch(TableSearch search) {
		this.search = search;
	}
	public List<TableOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<TableOrder> orders) {
		this.orders = orders;
	}
	public List<TableColum> getColums() {
		return columns;
	}
	public void setColums(List<TableColum> columns) {
		this.columns = columns;
	}
	public String[] getSearchParam() {
		return searchParam;
	}
	public void setSearchParam(String[] searchParam) {
		this.searchParam = searchParam;
	}
	@Override
	public String toString() {
		return "TableParam [start=" + start + ", length=" + length + ", draw="
				+ draw +  ", orders=" + orders
				+ ", columns=" + columns + ", searchParam="
				+ Arrays.toString(searchParam) + "]";
	}
}
