package com.et.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FoodMapper {
	/**
	 *  crud
	 * @param foodname
	 * @return
	 */
	public abstract List query();
	public abstract List<Food> queryByName(String foodname);
	public abstract List<Food> queryByName2(@Param("foodname")String foodname);
	public abstract int delete(int foodid);
	public abstract int add(String foodname,int price);
	public abstract int update(String foodname,int price);
	
	public abstract void saveFood(Food food);
}
