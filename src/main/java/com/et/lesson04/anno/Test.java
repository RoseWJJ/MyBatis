package com.et.lesson04.anno;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test {
	public static SqlSession getSession() throws Exception{
	String resource = "com/et/lesson04/anno/mybatis.xml";
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
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		Student student = new Student();
		
		student.setsName("张");
		student.setAddress("福");
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
	
}
