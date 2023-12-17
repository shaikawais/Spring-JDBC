package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import entities.Student;

@Component("studentDao")
public class StudentDaoImlp implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(Student st) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		this.jdbcTemplate.update(query, st.getId(), st.getName(), st.getCity());
	}

	public void update(Student st) {
		String query = "update student set name=?, city=? where id=?";
		this.jdbcTemplate.update(query, st.getName(), st.getCity(), st.getId());
	}

	public void delete(int studentId) {
		String query = "delete from student where id=?";
		this.jdbcTemplate.update(query, studentId);
	}

	public Student fetch(int studentId) {
		String query = "select * from student where id=?";
		RowMapper rw = new RowMapperImpl();
		return this.jdbcTemplate.queryForObject(query, rw, studentId);
	}

	public List<Student> getAllStudents() {
		String query = "select * from student";
		return this.jdbcTemplate.query(query, new RowMapperImpl());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
