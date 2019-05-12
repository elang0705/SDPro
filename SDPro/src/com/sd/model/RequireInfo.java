package com.sd.model;

import java.util.Date;

/**
 * 需求信息
 * @author elang
 *
 */
public class RequireInfo {
	/**
	 * 主键
	 */
	private int rid;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 分类
	 */
	private String category;
	/**
	 * 描述
	 */
	private String describe;
	/**
	 * 价格
	 */
	private float price;
	/**
	 * 电话
	 */
	private String mobile;
	/**
	 * 发布协议
	 */
	private String deal;
	/**
	 * 附件
	 */
	private String filePath;
	/**
	 * 状态：1：报名中；2：开发中；3：验收中；4已结项
	 * @return
	 */
	private String state;
	/**
	 * 报名截止日期
	 */
	private String endTime;
	/**
	 * 预计完成日期
	 */
	private String expectTime;
	/**
	 * 二级分类
	 */
	private String categoryChild;
	/**
	 * 创建时间
	 */
	private String creDate;
	/**
	 * 登录用户ID
	 */
	private int userId;
	/**
	 * 操作列
	 */
	private String todo;
	/**
	 * 是否上传过合同
	 */
	private int isUploadPact;
	/**
	 * 是否上传过作品
	 */
	private int isUploadWorks;
	/**
	 * 是否确定合作伙伴  0代表还没有人开始竞标需求，1代表有人竞标但还未确定，2代表已经确定人选
	 */
	private int isSure;
	public RequireInfo() {
		super();		
	}
	public RequireInfo(int rid, String title, String category, String describe,
			float price, String mobile, String deal, String filePath,
			String state, String endTime, String expectTime,
			String categoryChild, String creDate, int userId, String todo,
			int isUploadPact, int isUploadWorks, int isSure) {
		super();
		this.rid = rid;
		this.title = title;
		this.category = category;
		this.describe = describe;
		this.price = price;
		this.mobile = mobile;
		this.deal = deal;
		this.filePath = filePath;
		this.state = state;
		this.endTime = endTime;
		this.expectTime = expectTime;
		this.categoryChild = categoryChild;
		this.creDate = creDate;
		this.userId = userId;
		this.todo = todo;
		this.isUploadPact = isUploadPact;
		this.isUploadWorks = isUploadWorks;
		this.isSure = isSure;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDeal() {
		return deal;
	}
	public void setDeal(String deal) {
		this.deal = deal;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getExpectTime() {
		return expectTime;
	}
	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}
	public String getCategoryChild() {
		return categoryChild;
	}
	public void setCategoryChild(String categoryChild) {
		this.categoryChild = categoryChild;
	}
	public String getCreDate() {
		return creDate;
	}
	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public int getIsUploadPact() {
		return isUploadPact;
	}
	public void setIsUploadPact(int isUploadPact) {
		this.isUploadPact = isUploadPact;
	}
	public int getIsUploadWorks() {
		return isUploadWorks;
	}
	public void setIsUploadWorks(int isUploadWorks) {
		this.isUploadWorks = isUploadWorks;
	}
	public int getIsSure() {
		return isSure;
	}
	public void setIsSure(int isSure) {
		this.isSure = isSure;
	}
	@Override
	public String toString() {
		return "RequireInfo [rid=" + rid + ", title=" + title + ", category="
				+ category + ", describe=" + describe + ", price=" + price
				+ ", mobile=" + mobile + ", deal=" + deal + ", filePath="
				+ filePath + ", state=" + state + ", endTime=" + endTime
				+ ", expectTime=" + expectTime + ", categoryChild="
				+ categoryChild + ", creDate=" + creDate + ", userId=" + userId
				+ ", todo=" + todo + ", isUploadPact=" + isUploadPact
				+ ", isUploadWorks=" + isUploadWorks + ", isSure=" + isSure
				+ "]";
	}	
}
