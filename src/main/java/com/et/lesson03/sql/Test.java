package com.et.lesson03.sql;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class Test {
	public static SqlSession getSession() throws Exception{
	String resource = "com/et/lesson03/sql/mybatis.xml";
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
		List list = fm.queryFoodByName("辣");
//		List list = session.selectList("com.et.lesson02.ys.FoodMapper.query");
		System.out.println(list);
		log.debug(list);
	}
	
	
}
