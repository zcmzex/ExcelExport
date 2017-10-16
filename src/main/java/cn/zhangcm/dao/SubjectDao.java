package cn.zhangcm.dao;

import java.util.List;

import cn.zhangcm.bean.Subject;

public interface SubjectDao {
	
	void add(Subject subject);
	
	void delete(Long id);
	
	void update(Subject subject);
	
	List<Subject> findAll();
	
	Subject findById(Long id);
	
}
