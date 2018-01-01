package com.et.lesson02.pro;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class Test {
	public static SqlSession getSession() throws Exception{
	String resource = "com/et/lesson02/pro/mybatis.xml";
	// 加载获取文件流
	InputStream inputStream = Resources.getResourceAsStream(resource);
	// 工厂类 产生session
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	// session操作的是 指向sql语句的一个唯一标识符；
	SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	

	
	@org.junit.Test
	public void testpro() throws Exception{
		SqlSession session =getSession();
		Map map = new HashMap();
		map.put("p1", 100);
		map.put("p2", 110);
		map.put("result", 0);
		session.selectOne("proc.call_prg",map);
		System.out.println(map.get("result"));
	}
//	@org.junit.Test
//	public void testfun() throws Exception{
//		SqlSession session =getSession();
//		Map map = new HashMap();
//		map.put("p1", 100);
//		map.put("p2", 110);
//		map.put("result", 0);
//		session.selectOne("proc.call_prg",map);
//		System.out.println(map.get("result"));
//	}
}
