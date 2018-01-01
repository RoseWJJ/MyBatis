package com.et.lesson05.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

public class Test {
	public static void main(String[] args) throws Exception {
		//SerializePerson();
		Person p =  DeserializePerson();
		System.out.println(MessageFormat.format("id1={0},name1={1},sex={2},address={3}", p.getId(), p.getName(), p.getSex(), p.getAddress()));
		
	}

	public static void SerializePerson() throws Exception {
		Person p = new Person();
		p.setId(1);
		p.setName("王俊杰");
		p.setSex("男");
		p.setAddress("兰州");
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(
				new File("E:/Person.txt")));
		os.writeObject(p);

	}

	private static Person DeserializePerson() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				new File("E:/Person.txt")));
		Person person = (Person) ois.readObject();
		System.out.println("Person对象反序列化成功！");
		return person;
	}
}
