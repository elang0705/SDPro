package com.sd.model;

import java.util.List;

/**
 * 对需求竞标
 * @author elang
 *
 */
public class AcceptRequireInfo {
	/**
	 * 主键
	 */
	private String aid;
	/**
	 * 报价
	 */
	private float offerPrice;
	/**
	 * 周期
	 */
	private String period;
	/**
	 * 承诺服务
	 */
	private String promise;
	/**
	 * 所在地
	 */
	private String address;
	/**
	 * 进度
	 */
	private String progress;
	/**
	 * 风险
	 */
	private String risk;
	/**
	 * 是否签订合同
	 */
	private String isReach;
	/**
	 * 关联用户
	 */
	private int uid;
	/**
	 * 关联需求
	 */
	private int rid;
	@Override
	public String toString() {
		return "AcceptRequireInfo [aid=" + aid + ", offerPrice=" + offerPrice
				+ ", period=" + period + ", promise=" + promise + ", address="
				+ address + ", progress=" + progress + ", risk=" + risk
				+ ", isReach=" + isReach + ", uid=" + uid + ", rid=" + rid
				+ "]";
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public float getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(float offerPrice) {
		this.offerPrice = offerPrice;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPromise() {
		return promise;
	}
	public void setPromise(String promise) {
		this.promise = promise;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getIsReach() {
		return isReach;
	}
	public void setIsReach(String isReach) {
		this.isReach = isReach;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public AcceptRequireInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
