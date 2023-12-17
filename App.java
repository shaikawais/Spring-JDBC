package com.spring.jdbc.Spring_JDBC;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StudentDao;
import dao.StudentDaoImlp;
import entities.Student;

public class App {
	public static void main(String[] args) {

//		By Using XML file
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/Spring_JDBC/config.xml");

//		By Using Annotations With Java File
		ApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
		StudentDao stDao = context2.getBean("studentDao", StudentDao.class);
		Student st = new Student();
//		st.setId(105);
//		st.setName("Shoaib");
//		st.setCity("Hyderabad");

//		stDao.insert(st);
//		stDao.update(st);
//		stDao.delete(103);
//		System.out.println(stDao.fetch(102));
		System.out.println("Done");

//		Fetch All
		List<Student> list = stDao.getAllStudents();
		for (Student st1 : list)
			System.out.println(st1);

	}
}
