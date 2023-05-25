package com.example.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.Model.StudentDto;

@Repository
public class StudentDao extends SqlSessionDaoSupport implements IStudentDao {
	@Override
	@Autowired
	public void setSqlSessionFactory(@Qualifier("defaultDS") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}	

	public List<StudentDto> GetListStudent() {
		return getSqlSession().selectList("StudentMapper.selectAll");
	}

	public int insert(StudentDto obj) {
//		String sql = "INSERT INTO student (name, age, class) VALUES (?,?,?)";
//		return _jdbcTemplate.update(sql, obj.getName(), obj.getAge(), obj.getClassStudent());
		return getSqlSession().insert("StudentMapper.insertStudent", obj);

	}

	public void delete(String ID) {
		getSqlSession().delete("deleteStudent", ID);
	}
	public StudentDto findById(String ID) {
		return getSqlSession().selectOne("findById", ID);
	}

	public void update(StudentDto obj) {
		getSqlSession().update("updateStudent", obj);
	}

	public List<StudentDto> findByName(String name) {
		return getSqlSession().selectList("findByName", name);
	}

}
