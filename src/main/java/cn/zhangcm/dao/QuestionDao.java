package cn.zhangcm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhangcm.bean.Question;

public interface QuestionDao {
	
	void addQuestion(Question question);
	
	void delete(Long id);
	
	void update(Question question);
	
	List<Question> findAll();

	Question findById(Long id);
	
	List<Question> findAllByTypeAndSub(@Param("type") int type,@Param("subid")String subid);
	
}
