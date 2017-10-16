package cn.zhangcm.service;

import java.util.List;

import cn.zhangcm.bean.Teacher;

public interface TeacherService {
	
	void addTeacher(Teacher t);
	
	void updateTeacher(Teacher t);

	void deleteTeacher(Long id);
	
	void updatePass(Long id,String oldPassword,String newPassword);
	
	List<Teacher> getAll();
	
	Teacher getTeacherById(Long id);
	
	Teacher getTeacherByEmail(String email);
	
	
	
}
