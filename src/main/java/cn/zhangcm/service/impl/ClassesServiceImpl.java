package cn.zhangcm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zhangcm.bean.Classes;
import cn.zhangcm.dao.ClassesDao;
import cn.zhangcm.service.ClassesService;
import cn.zhangcm.utils.BaseService;

public class ClassesServiceImpl implements ClassesService {

	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ClassesService#addClasses(cn.zhangcm.bean.Classes)
	 */
	@Override
	public void addClasses(Classes classes){
		try(SqlSession session = BaseService.openSession()){
			ClassesDao cdao = session.getMapper(ClassesDao.class);
			cdao.addClasses(classes);
			session.commit();
		}
	}
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ClassesService#updateClasses(cn.zhangcm.bean.Classes)
	 */
	@Override
	public void updateClasses(Classes classes){
		try(SqlSession session = BaseService.openSession()){
			ClassesDao cdao = session.getMapper(ClassesDao.class);
			cdao.updateClasses(classes);
			session.commit();
		}
	}
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ClassesService#findById(java.lang.Long)
	 */
	@Override
	public Classes findById(Long id){
		try(SqlSession session = BaseService.openSession()){
			ClassesDao cdao = session.getMapper(ClassesDao.class);
			return cdao.getClassesById(id);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ClassesService#findAll()
	 */
	@Override
	public List findAll(){
		try(SqlSession session = BaseService.openSession()){
			ClassesDao cdao = session.getMapper(ClassesDao.class);
			return cdao.getAll();
		}
	}
	
}
