package cn.zhangcm.service;

import java.util.List;

import cn.zhangcm.bean.Classes;
import cn.zhangcm.bean.Student;

public interface StudentService {

	public abstract void addStudent(Student student);

	public abstract void updateStudent(Student student);

	public abstract List findAllByClassId(Long class_id);

	public abstract Student findById(Long id);

	public abstract Student findByNum(String num);

	List findByMes(Student student);

}