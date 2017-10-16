package cn.zhangcm.dao;

import java.util.List;

import cn.zhangcm.bean.Classes;

public interface ClassesDao {
	
	 void addClasses(Classes classes);
	 
	 void updateClasses(Classes classes);
	 
	 List<Classes> getAll();
	 
	 Classes getClassesById(Long id);
	
}
