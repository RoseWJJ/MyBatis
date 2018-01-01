package com.et.lesson02.xml;

public class Food {
	private int foodid;
	private String foodname;
	private int price;
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return "Food [foodid=" + foodid + ", foodname=" + foodname + ", price="
				+ price + "]";
	}
	
	
	
	
}
