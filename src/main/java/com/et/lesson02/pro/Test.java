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
	// ���ػ�ȡ�ļ���
	InputStream inputStream = Resources.getResourceAsStream(resource);
	// ������ ����session
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	// session�������� ָ��sql����һ��Ψһ��ʶ����
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
