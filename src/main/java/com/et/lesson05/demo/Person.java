package com.et.lesson05.demo;

import java.io.Serializable;

public class Person  implements Serializable{
	private int id;
	private String name;
	private String sex;
	private String address;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Pserson [address=" + address + ", id=" + id + ", name=" + name
				+ ", sex=" + sex + "]";
	}
	
}
