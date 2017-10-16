package cn.zhangcm.dao;

import java.util.List;

import cn.zhangcm.bean.Classes;
import cn.zhangcm.bean.Student;

public interface StudentDao {
	
	void addStudent(Student student);
	
	void updateStudent(Student student);
	
	List<Student> findAllByClassId(Long class_id);
	
	Student findById(Long id);
	
	Student findByNum(String num);
	
	List<Student> findByMes(Student student);
}
