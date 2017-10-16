package cn.zhangcm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zhangcm.bean.Subject;
import cn.zhangcm.dao.SubjectDao;
import cn.zhangcm.service.SubjectService;
import cn.zhangcm.utils.BaseService;

public class SubjectServiceImpl implements SubjectService {
	
	/*
	 * ���һ����Ŀ
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.SubjectService#addSubject(cn.zhangcm.bean.Subject)
	 */
	@Override
	public void addSubject(Subject subject){
		try(SqlSession session = BaseService.openSession()){
			SubjectDao sdao = session.getMapper(SubjectDao.class);
			sdao.add(subject);
			session.commit();
		}
	}
	/*
	 * ����һ����Ŀ
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.SubjectService#update(cn.zhangcm.bean.Subject)
	 */
	@Override
	public void update(Subject subject){
		try(SqlSession session = BaseService.openSession()){
			SubjectDao sdao = session.getMapper(SubjectDao.class);
			sdao.update(subject);
			session.commit();
		}
	}
	/*
	 *	�õ�һ����Ŀ����Ϣ,Ҳ�ܻ����ص�����
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.SubjectService#findById(java.lang.Long)
	 */
	@Override
	public Subject findById(Long id){
		try(SqlSession session = BaseService.openSession()){
			SubjectDao sdao = session.getMapper(SubjectDao.class);
			return sdao.findById(id);
		}
	}
	/*
	 * ������п�Ŀ��Ϣ
	 * 
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.SubjectService#findAll()
	 */
	@Override
	public List findAll(){
		try(SqlSession session = BaseService.openSession()){
			SubjectDao sdao = session.getMapper(SubjectDao.class);
			return sdao.findAll();
		}
	}
}
