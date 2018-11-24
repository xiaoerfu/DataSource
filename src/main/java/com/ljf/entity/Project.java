package com.ljf.entity;

public class Project {
	
	private long id;				// ID号
	private String pj_num;			// 项目编号
	private String pj_name;			// 项目名
	private String db_ip;			// 数据库IP
	private String db_names;		// 数据库名
	private String pj_type;			// 项目类型
	private String head_image;		// 微信头部图片
	private String head_icon;		// 微信列表图标
	private String remark;			// 备注
	private String grade;			// 标志位
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPj_num() {
		return pj_num;
	}
	public void setPj_num(String pj_num) {
		this.pj_num = pj_num;
	}
	public String getPj_name() {
		return pj_name;
	}
	public void setPj_name(String pj_name) {
		this.pj_name = pj_name;
	}
	public String getDb_ip() {
		return db_ip;
	}
	public void setDb_ip(String db_ip) {
		this.db_ip = db_ip;
	}
	public String getDb_names() {
		return db_names;
	}
	public void setDb_names(String db_names) {
		this.db_names = db_names;
	}
	public String getPj_type() {
		return pj_type;
	}
	public void setPj_type(String pj_type) {
		this.pj_type = pj_type;
	}
	public String getHead_image() {
		return head_image;
	}
	public void setHead_image(String head_image) {
		this.head_image = head_image;
	}
	public String getHead_icon() {
		return head_icon;
	}
	public void setHead_icon(String head_icon) {
		this.head_icon = head_icon;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", pj_num=" + pj_num + ", pj_name=" + pj_name + ", db_ip=" + db_ip + ", db_names="
				+ db_names + ", pj_type=" + pj_type + ", head_image=" + head_image + ", head_icon=" + head_icon
				+ ", remark=" + remark + ", grade=" + grade + "]";
	}
	
}
