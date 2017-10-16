package cn.zhangcm.service;

import java.util.List;

import cn.zhangcm.bean.Subject;

public interface SubjectService {

	/*
	 * ���һ����Ŀ
	 */
	public abstract void addSubject(Subject subject);

	/*
	 * ����һ����Ŀ
	 */
	public abstract void update(Subject subject);

	/*
	 *	�õ�һ����Ŀ����Ϣ,Ҳ�ܻ����ص�����
	 */
	public abstract Subject findById(Long id);

	/*
	 * ������п�Ŀ��Ϣ
	 * 
	 */
	public abstract List findAll();

}