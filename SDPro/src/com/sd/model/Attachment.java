/**
 * 
 */
package com.sd.model;

/**
 * 附件实体表
 * @author elang
 *
 */
public class Attachment {
	/**主键*/
	private int id;
	/**关联业务表主键*/
	private int fid;
	/**附件名称*/
	private String fileName;
	/**附件存放路径*/
	private String filePath;
	/**创建时间*/
	private String createTime;
	/**创建者*/
	private int creator;
	/**
	 * 附件类型：0:代表头像;1代表需求;2代表合同;3代表作品;
	 * 
	 * */
	private int type;
	public Attachment() {
		super();
	}
	public Attachment(int id, int fid, String fileName, String filePath,
			String createTime, int creator, int type) {
		super();
		this.id = id;
		this.fid = fid;
		this.fileName = fileName;
		this.filePath = filePath;
		this.createTime = createTime;
		this.creator = creator;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Attachment [id=" + id + ", fid=" + fid + ", fileName="
				+ fileName + ", filePath=" + filePath + ", createTime="
				+ createTime + ", creator=" + creator + ", type=" + type + "]";
	}
}
