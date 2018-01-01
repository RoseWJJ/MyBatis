package com.et.lesson03.returnMap.xml;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class Test {
	public static SqlSession getSession() throws Exception{
	String resource = "com/et/lesson03/returnMap/xml/mybatis.xml";
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
	
		GradeMapper gm =session.getMapper(GradeMapper.class);
		List<Grade> list = gm.queryAllGrade();
		for (Grade grade : list) {
			System.out.println(grade.getGid()+"-----"+grade.getGname1());
		}
		
	}
	@org.junit.Test
	public void ManyToOne() throws Exception{
		SqlSession session =getSession();
	
		StudentMapper gm =session.getMapper(StudentMapper.class);
		Student student = gm.queryStudent(1);
		System.out.println(student.getsName()+"--"+student.getGrade().getGname1());
		
	}
	
	@org.junit.Test
	public void OneToMany() throws Exception{
		SqlSession session =getSession();
	
		GradeMapper gm =session.getMapper(GradeMapper.class);
		Grade g = gm.queryGrade(1);
		for (Student gs : g.getStudentList()) {
			System.out.println(gs.getsName());
		}
		System.out.println(g.getGname1()+"-------"+g.getStudentList().size());
		
	}
	
}
