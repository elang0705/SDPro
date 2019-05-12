package com.sd.model;
/**
 * 团队信息
 * @author elang
 *
 */
public class TeamInfo {
	/**
	 * 主键
	 */
	private int tid;
	/**
	 * 名称
	 */
	private String tName;
	/**
	 * 团队成员
	 */
	private String members;
	/**
	 * 擅长领域
	 */
	private String skills;
	/**
	 * 信誉度
	 */
	private String credibility;
	/**
	 * 等级
	 */
	private String level;
	public TeamInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
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
	@Override
	public String toString() {
		return "TeamInfo [tName=" + tName + ", members=" + members
				+ ", skills=" + skills + ", credibility=" + credibility
				+ ", level=" + level + "]";
	}

}
