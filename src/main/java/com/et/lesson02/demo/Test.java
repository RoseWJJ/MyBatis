package com.et.lesson02.demo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class Test {
	public static SqlSession getSession() throws Exception{
	String resource = "mybatis.xml";
	// ���ػ�ȡ�ļ���
	InputStream inputStream = Resources.getResourceAsStream(resource);
	// ������ ����session
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream);
	// session�������� ָ��sql����һ��Ψһ��ʶ����
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	
	public void test1() throws Exception{
		SqlSession session = getSession();
		List list = session.selectList("a.select");
		System.out.println(list);
		
	}
	//�Զ���log
	Logger  log =  Logger.getLogger(Test.class);
	@org.junit.Test
	public void test2() throws Exception{
		SqlSession session = getSession();
		Map map = new HashMap();
		map.put("foodname", "�������");
		map.put("price", 60);
		List list = session.selectList("a.getUserById",map);
		log.debug(list);
		
	}
	@org.junit.Test
	public void test3() throws Exception{
		SqlSession session = getSession();
		Map map = new HashMap();
		map.put("foodname", "�������");
		map.put("price", 60);
		List list = session.selectList("a.getUserById2",map);
		log.debug(list);
		
	}
	@org.junit.Test
	public void test4() throws Exception{
		SqlSession session = getSession();
		Food food = new Food();
		food.setFoodname("�������");
		food.setPrice(60);
		List list = session.selectList("a.getUserById2",food);
		log.debug(list);
		
	}
	
	
	@org.junit.Test
	public void test5() throws Exception{
		SqlSession session = getSession();
		Food food = new Food();
		food.setFoodname("С��Ϻ");
		food.setPrice(50);
		session.insert("a.saveFood",food);
		session.commit();
	}
}
