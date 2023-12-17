package dao;

import java.util.List;

import entities.Student;

public interface StudentDao {

	public void insert(Student st);

	public void update(Student st);

	public void delete(int studentId);

	public Student fetch(int studentId);
	
	public List<Student> getAllStudents();
}
