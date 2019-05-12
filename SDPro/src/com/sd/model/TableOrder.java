package com.sd.model;

public class TableOrder {
	private static final String ORDER_DESC = "DESC";
	private static final String ORDER_ASC = "ASC";
	private int colum;//排序列索引
	private String columName;//列名称
	private String dir;//排序类型
	public int getColum() {
		return colum;
	}
	public void setColum(int colum) {
		this.colum = colum;
	}
	public String getColumName() {
		return columName;
	}
	public void setColumName(String columName) {
		this.columName = columName;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public TableOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TableOrder(int colum, String columName, String dir) {
		super();
		this.colum = colum;
		this.columName = columName;
		this.dir = dir;
	}
	@Override
	public String toString() {
		return "TableOrder [colum=" + colum + ", columName=" + columName
				+ ", dir=" + dir + "]";
	}

}
