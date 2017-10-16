package cn.zhangcm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zhangcm.bean.ExamItem;
import cn.zhangcm.dao.ExamItemDao;
import cn.zhangcm.service.ExamItemService;
import cn.zhangcm.utils.BaseService;

public class ExamItemServiceImpl implements ExamItemService {
	
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ExamItemService#addExamItem(cn.zhangcm.bean.ExamItem)
	 */
	@Override
	public void addExamItem(ExamItem examItem){
		try(SqlSession session = BaseService.openSession()){
			ExamItemDao edao = session.getMapper(ExamItemDao.class);
			edao.addExamItem(examItem);
			session.commit();
		}
	}

	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ExamItemService#updateExamItem(cn.zhangcm.bean.ExamItem)
	 */
	@Override
	public void updateExamItem(ExamItem examItem){
		try(SqlSession session = BaseService.openSession()){
			ExamItemDao edao = session.getMapper(ExamItemDao.class);
			edao.updateExamItem(examItem);
			session.commit();
		}
	}
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ExamItemService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id){
		try(SqlSession session = BaseService.openSession()){
			ExamItemDao edao = session.getMapper(ExamItemDao.class);
			edao.delete(id);
			session.commit();
		}
	}

	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ExamItemService#findByClassid(java.lang.Long)
	 */
	@Override
	public ExamItem findByClassid(Long class_id){
		try(SqlSession session = BaseService.openSession()){
			ExamItemDao edao = session.getMapper(ExamItemDao.class);
			return edao.findByClassid(class_id);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ExamItemService#findAll()
	 */
	@Override
	public List<ExamItem> findAll(){
		try(SqlSession session = BaseService.openSession()){
			ExamItemDao edao = session.getMapper(ExamItemDao.class);
			return edao.findAll();
		}
	}
	@Override
	public List<ExamItem> findAllByClassId(Long class_id){
		try(SqlSession session = BaseService.openSession()){
			ExamItemDao edao = session.getMapper(ExamItemDao.class);
			return edao.findAllByClassId(class_id);
		}
	}
}
