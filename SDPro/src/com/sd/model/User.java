package com.sd.model;
/**
 * 注册用户信息
 * @author elang
 *
 */
public class User {
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 注册时间
	 */
	private String createTime;
	/**
	 * 用户类型 默认为1:个人用户;2:团队用户;3:企业用户
	 */
	private int type;
	/**
	 * 角色
	 */
	private String role;
	
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ ", phone=" + phone + ", createTime=" + createTime + ", type="
				+ type + ",role="+role+"]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
