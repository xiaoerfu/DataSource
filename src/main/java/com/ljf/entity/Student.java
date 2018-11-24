package com.ljf.entity;

/**
 * 
 * @ClassName:  Student   
 * @Description:TODO(学生实体类)   
 * @author: 铭汉科技—LJF 
 * @date:   2018年11月15日 上午11:36:18   
 *
 */
public class Student {
	 
	private int stu_id;
	private String stu_name;
	private String stu_gender;
	private int stu_age;
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_gender() {
		return stu_gender;
	}
	public void setStu_gender(String stu_gender) {
		this.stu_gender = stu_gender;
	}
	public int getStu_age() {
		return stu_age;
	}
	public void setStu_age(Integer stu_age) {
		this.stu_age = stu_age;
	}
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_gender=" + stu_gender + ", stu_age="
				+ stu_age + "]";
	}
	
}
