package com.ljf.entity;

public class House {

	private int id;
	private String house_name;
	private long parent_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public long getParent_id() {
		return parent_id;
	}
	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", house_name=" + house_name + ", parent_id=" + parent_id + "]";
	}
	
}
