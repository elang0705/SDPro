package com.sd.model;
/**
 * 个人用户信息
 * @author elang
 *
 */
public class PersonInfo {
	/**
	 * 主键
	 */
	private int pid;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 头像
	 */
	private String headImg;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 身份证
	 */
	private String identity;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * QQ
	 */
	private String qq;
	/**
	 * 微信
	 */
	private String weixin;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 参加工作时间
	 */
	private String workTime;
	/**
	 * 常住地
	 */
	private String address;
	/**
	 * 毕业院校
	 */
	private String university;
	/**
	 * 所学专业
	 */
	private String major;
	/**
	 * 职业
	 */
	private String professional;
	/**
	 * 自我介绍
	 */
	private String perIntroduce;
	/**
	 * 接包意向
	 */
	private String intention;
	/**
	 * 项目案例
	 */
	private String projectCase;
	/**
	 * 信誉度
	 */
	private String credibility;
	/**
	 * 等级 (高级职位)
	 */
	private String level;
	/**
	 * 职业资格证
	 */
	private String workCertificate;
	/**
	 * 联系电话
	 */
	private String phone;
	
	public PersonInfo() {
		super();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getPerIntroduce() {
		return perIntroduce;
	}
	public void setPerIntroduce(String perIntroduce) {
		this.perIntroduce = perIntroduce;
	}
	public String getIntention() {
		return intention;
	}
	public void setIntention(String intention) {
		this.intention = intention;
	}
	public String getProjectCase() {
		return projectCase;
	}
	public void setProjectCase(String projectCase) {
		this.projectCase = projectCase;
	}
	public String getCredibility() {
		return credibility;
	}
	public void setCredibility(String credibility) {
		this.credibility = credibility;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getWorkCertificate() {
		return workCertificate;
	}
	public void setWorkCertificate(String workCertificate) {
		this.workCertificate = workCertificate;
	}
	@Override
	public String toString() {
		return "PersonInfo [realName=" + realName + ", nickname=" + nickname
				+ ", headImg=" + headImg + ", sex=" + sex + ", education="
				+ education + ", identity=" + identity + ", birthday="
				+ birthday + ", qq=" + qq + ", weixin=" + weixin + ", email="
				+ email + ", workTime=" + workTime + ", address=" + address
				+ ", university=" + university + ", major=" + major
				+ ", professional=" + professional + ", perIntroduce="
				+ perIntroduce + ", intention=" + intention + ", projectCase="
				+ projectCase + ", credibility=" + credibility + ", level="
				+ level + ", workCertificate=" + workCertificate + ",phone"+phone+ "]";
	}

}
