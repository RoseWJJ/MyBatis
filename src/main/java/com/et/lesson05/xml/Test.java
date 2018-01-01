package com.et.lesson05.xml;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import redis.clients.jedis.Jedis;


public class Test {
	public static SqlSessionFactory getSessionFactory() throws Exception{
		String resource = "com/et/lesson05/xml/mybatis.xml";
		// 加载获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 工厂类 产生session
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		return sqlSessionFactory;
		
	}
	public static SqlSession getSession() throws Exception{
	String resource = "com/et/lesson05/xml/mybatis.xml";
	// 加载获取文件流
	InputStream inputStream = Resources.getResourceAsStream(resource);
	// 工厂类 产生session
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream);
	// session操作的是 指向sql语句的一个唯一标识符；
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	
	@org.junit.Test
	public void test1() throws Exception{
		SqlSession session =getSession();
		PersonMapper sMapper = session.getMapper(PersonMapper.class);
		Person p = sMapper.queryPersonById(1);
		System.out.println(p.getName());
		Person p1 = sMapper.queryPersonById(1);
		System.out.println(p1.getName());
		
	}
	
	
	@org.junit.Test
	public void test2() throws Exception{
//		SqlSessionFactory sessionFactory = getSessionFactory();
//		SqlSession session = sessionFactory.openSession();
//		SqlSession session1 = sessionFactory.openSession();
//
//		Person p = session.selectOne("com.et.lesson05.xml.PersonMapper.queryPersonById",1);
//		session.close();
//		Person p1 = session1.selectOne("com.et.lesson05.xml.PersonMapper.queryPersonById",1);
		Jedis jedis = new Jedis("localhost");
		jedis.set("name", "xx");
		System.out.println(jedis.get("name"));
	}
}
