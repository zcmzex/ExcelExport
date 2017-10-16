package cn.zhangcm.dao;

import java.util.List;

import cn.zhangcm.bean.ExamItem;

public interface ExamItemDao {
	
	void addExamItem(ExamItem examitem);
	
	void updateExamItem(ExamItem examitem);

	void delete(Long id);
	
	List<ExamItem> findAll();
	
	ExamItem findByClassid(Long class_id);
	
	List<ExamItem> findAllByClassId(Long class_id);
	
}
