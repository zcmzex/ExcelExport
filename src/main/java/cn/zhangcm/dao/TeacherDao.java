package cn.zhangcm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhangcm.bean.Teacher;

public interface TeacherDao {

	Teacher findTeacherById(Long id);
	
	Teacher findTeacherByEmail(String email);
	
	void addTeacher(Teacher t);
	
	List<Teacher> findAll();
	
	void updateTeacher(Teacher t);
	
	void deleteTeacher(Long id);
	
	void updatePassword(@Param("id")Long id,@Param("password")String password);
	
}