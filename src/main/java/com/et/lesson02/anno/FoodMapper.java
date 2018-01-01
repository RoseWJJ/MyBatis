package com.et.lesson02.anno;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.et.lesson02.xml.Food;

public interface FoodMapper {
	/**
	 *  crud
	 * @param foodname
	 * @return
	 */
	@Select("select * from food")
	public abstract List<Map> query();
	@Select("select * from food where foodname like '%${foodname}%'")
	public abstract List<Food> queryByName(@Param("foodname") String foodname);
	@Delete("delete  from food where foodid=#{foodid}")
	public abstract int delete(@Param("foodid")int foodid);
	@Insert("insert into food values(FOOD_SEC.NEXTVAL,#{foodname},#{price})")
	public abstract int add(@Param("foodname")String foodname,@Param("price")int price);
	@Update("update food set price=#{price} where foodname=#{foodname}")
	public abstract int update(@Param("foodname")String foodname,@Param("price")int price);
	@SelectKey(before=true, keyProperty = "foodid", resultType = int.class, statement = { "select FOOD_SEC.NEXTVAL FROM DUAL" })
	@Insert("insert into food values(#{foodid},#{foodname},#{price})")
	public abstract void saveFood(Food food);
}
