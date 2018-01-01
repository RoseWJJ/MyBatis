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
	// ���ػ�ȡ�ļ���
	InputStream inputStream = Resources.getResourceAsStream(resource);
	// ������ ����session
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream);
	// session�������� ָ��sql����һ��Ψһ��ʶ����
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	
	Logger  log =  Logger.getLogger(Test.class);
	@org.junit.Test
	public void test1() throws Exception{
		SqlSession session =getSession();
	
		FoodMapper fm =session.getMapper(FoodMapper.class);
		List list = fm.queryFoodByName("��");
//		List list = session.selectList("com.et.lesson02.ys.FoodMapper.query");
		System.out.println(list);
		log.debug(list);
	}
	
	
}
