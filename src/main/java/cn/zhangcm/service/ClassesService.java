package cn.zhangcm.service;

import java.util.List;

import cn.zhangcm.bean.Classes;

public interface ClassesService {

	public abstract void addClasses(Classes classes);

	public abstract void updateClasses(Classes classes);

	public abstract Classes findById(Long id);

	public abstract List findAll();

}