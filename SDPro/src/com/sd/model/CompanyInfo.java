package com.sd.model;
/**
 * 企业用户信息
 * @author elang
 *
 */
public class CompanyInfo {
	/**
	 * 主键
	 */
	private int cid;
	/**
	 * 企业名称
	 */
	private String cName;
	/**
	 * 企业资质照片
	 */
	private String image;
	public CompanyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	@Override
	public String toString() {
		return "CompanyInfo [cName=" + cName + ", image=" + image + "]";
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
