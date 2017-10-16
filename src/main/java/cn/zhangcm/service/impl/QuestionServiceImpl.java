package cn.zhangcm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zhangcm.bean.Item;
import cn.zhangcm.bean.Question;
import cn.zhangcm.dao.ItemDao;
import cn.zhangcm.dao.QuestionDao;
import cn.zhangcm.service.QuestionService;
import cn.zhangcm.utils.BaseService;

public class QuestionServiceImpl implements QuestionService  {
	
	/*
	 * ���һ�����Ⲣ���ѡ��
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.QuestionService#addQuestion(cn.zhangcm.bean.Question)
	 */

	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.QuestionService#addQuestion(cn.zhangcm.bean.Question)
	 */
	@Override
	public void addQuestion(Question question){
		try(SqlSession session = BaseService.openSession()){
			QuestionDao qdao = session.getMapper(QuestionDao.class);
			ItemDao idao = session.getMapper(ItemDao.class);
			qdao.addQuestion(question);
			for(Item item : question.getList()){
				idao.add(item);
			}
			session.commit();
		}
	}


	/*
	 * Ѱ��һ�����⣬�����ܹ��õ������Ŀ�Ŀ�ͳ�����
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.QuestionService#findById(java.lang.Long)
	 */

	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.QuestionService#findById(java.lang.Long)
	 */
	@Override
	public Question findById(Long id){
		try(SqlSession session = BaseService.openSession()){
			QuestionDao qdao = session.getMapper(QuestionDao.class);
			return qdao.findById(id);
		}
	}


	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.QuestionService#update(cn.zhangcm.bean.Question)
	 */
	@Override
	public void update(Question question) {
		// TODO Auto-generated method stub
		try(SqlSession session = BaseService.openSession()){
			QuestionDao idao = session.getMapper(QuestionDao.class);
			idao.update(question);
			session.commit();
		}
	}
	@Override
	public List findAllByTypeAndSub(int type,String subid){
				try(SqlSession session = BaseService.openSession()){
					QuestionDao idao = session.getMapper(QuestionDao.class);
					return idao.findAllByTypeAndSub(type, subid);
			}
	}

}