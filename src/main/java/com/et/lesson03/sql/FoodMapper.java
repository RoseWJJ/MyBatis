package com.et.lesson03.sql;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface FoodMapper {
	
	public abstract List queryFoodByName(@Param("foodname")String foodname);
	
}
