package cn.zhangcm.service;

import java.util.List;

import cn.zhangcm.bean.Question;

public interface QuestionService {

	public abstract void addQuestion(Question question);

	public abstract Question findById(Long id);

	public abstract void update(Question question);

	List findAllByTypeAndSub(int type, String subid);

}