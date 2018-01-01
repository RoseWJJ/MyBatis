package com.et.lesson02.xml;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class Test {
	public static SqlSession getSession() throws Exception{
	String resource = "mybatis.xml";
	// 加载获取文件流
	InputStream inputStream = Resources.getResourceAsStream(resource);
	// 工厂类 产生session
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream);
	// session操作的是 指向sql语句的一个唯一标识符；
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	
	Logger  log =  Logger.getLogger(Test.class);
	@org.junit.Test
	public void test1() throws Exception{
		SqlSession session =getSession();
	
		FoodMapper fm =session.getMapper(FoodMapper.class);
		List list = fm.query();
//		List list = session.selectList("com.et.lesson02.ys.FoodMapper.query");
		System.out.println(list);
		log.debug(list);
	}
	@org.junit.Test
	public void test21() throws Exception{
		SqlSession session =getSession();
		FoodMapper fm =session.getMapper(FoodMapper.class);
		List<Food> list = fm.queryByName("%辣%");
		//List list = session.selectList("com.et.lesson02.ys.FoodMapper.queryById",1);
		System.out.println(list);
		log.debug(list);
	}
	
	@org.junit.Test
	public void test22() throws Exception{
		SqlSession session =getSession();
		FoodMapper fm =session.getMapper(FoodMapper.class);
		List<Food> list = fm.queryByName2("辣");
		//List list = session.selectList("com.et.lesson02.ys.FoodMapper.queryById",1);
		System.out.println(list);
		log.debug(list);
	}
	@org.junit.Test
	public void test3() throws Exception{
		SqlSession session =getSession();
		FoodMapper fm =session.getMapper(FoodMapper.class);
		
		fm.add("zs", 100);
		session.commit();
	
	}
	@org.junit.Test
	public void test4() throws Exception{
		SqlSession session =getSession();
		FoodMapper fm =session.getMapper(FoodMapper.class);
		int i = fm.delete(9);
		session.commit();
		log.debug(i);
	}
	
	@org.junit.Test
	public void test5() throws Exception{
		SqlSession session =getSession();
		FoodMapper fm =session.getMapper(FoodMapper.class);
		int i = fm.update("青椒炒肉", 900);
		session.commit();
		log.debug(i);
	}
	

	
	@org.junit.Test
	public void test6() throws Exception{
		SqlSession session =getSession();
		FoodMapper fm =session.getMapper(FoodMapper.class);
		Food food = new Food();
		food.setFoodname("XS");
		food.setPrice(20);
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodid());
	}
}
