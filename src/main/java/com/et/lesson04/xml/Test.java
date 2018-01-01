package com.et.lesson04.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test {
	public static SqlSession getSession() throws Exception{
	String resource = "com/et/lesson04/xml/mybatis.xml";
	// ���ػ�ȡ�ļ���
	InputStream inputStream = Resources.getResourceAsStream(resource);
	// ������ ����session
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream);
	// session�������� ָ��sql����һ��Ψһ��ʶ����
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	

	@org.junit.Test
	public void test1() throws Exception{
		SqlSession session =getSession();
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setsName("��");
		student.setAddress("��");
		List<Student> list = sMapper.queryStudent(student);
		for (Student s : list) {
			System.out.println(s.getsName()+"--"+s.getAddress());
		}
		
		
	}
	
	@org.junit.Test
	public void test2() throws Exception{
		SqlSession session =getSession();
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		
		
		List<Student> list = sMapper.queryStudentBySex(0);
		for (Student s : list) {
			System.out.println(s.getsName()+"--"+s.getAddress());
		}
		
		
	}
	
	
	@org.junit.Test
	public void test3() throws Exception{
		SqlSession session =getSession();
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setStudentId(1);
		student.setsName("����");
		student.setAge(100);
		sMapper.updateStudent(student);
		session.commit();
	}
	
	
	@org.junit.Test
	public void test4() throws Exception{
		SqlSession session =getSession();
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		Student student = new Student();
		List  list= new ArrayList();
		list.add(1);
		list.add(1);
		list.add(3);
	    List <Student> l = sMapper.querySudentByGrade(list);
		for (Student s : l) {
			System.out.println(s.getsName()+"-----"+s.getAddress());
		}
	}
}
