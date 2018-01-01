package com.et.lesson01;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App {
	public static void main(String[] args) throws Exception {
		String resource = "com/et/lesson01/mybatis.xml";
		// 加载获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 工厂类 产生session
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// session操作的是 指向sql语句的一个唯一标识符；
		SqlSession session = sqlSessionFactory.openSession();
		




// int a = session.insert("a.insert");
// session.commit();
// System.out.println(a);
// int update = session.update("a.update");
// session.commit();
// System.out.println(update);

// int delete = session.delete("a.delete");
// session.commit();
// System.out.println(delete);
// 查询所有 对象
// List foods = session.selectList("a.getUser");
// System.out.println(foods);
// 查询单个 对象
// Food foods1 = (Food) session.selectOne("a.getUser");
// System.out.println(foods1);
// 查询单个 对象根据id
// String statement = "a.getUserById";
// Food food = session.selectOne(statement,2);
// System.out.println(food);
//    	
		
		String statement = "a.getUserById";
		
	}
 }
