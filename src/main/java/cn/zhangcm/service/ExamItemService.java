package cn.zhangcm.service;

import java.util.List;

import cn.zhangcm.bean.ExamItem;

public interface ExamItemService {

	public abstract void addExamItem(ExamItem examItem);

	public abstract void updateExamItem(ExamItem examItem);

	public abstract void delete(Long id);

	public abstract ExamItem findByClassid(Long class_id);

	public abstract List<ExamItem> findAll();

	List<ExamItem> findAllByClassId(Long class_id);

}