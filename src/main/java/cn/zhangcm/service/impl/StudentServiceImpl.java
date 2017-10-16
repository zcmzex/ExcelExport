package cn.zhangcm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zhangcm.bean.Classes;
import cn.zhangcm.bean.Student;
import cn.zhangcm.dao.ClassesDao;
import cn.zhangcm.dao.StudentDao;
import cn.zhangcm.service.StudentService;
import cn.zhangcm.utils.BaseService;

public class StudentServiceImpl implements StudentService {
	
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.StudentService#addStudent(cn.zhangcm.bean.Student)
	 */
	@Override
	public void addStudent(Student student){
		try(SqlSession session = BaseService.openSession()){
			StudentDao sdao = session.getMapper(StudentDao.class);
			sdao.addStudent(student);
			session.commit();
		}
	}
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.StudentService#updateStudent(cn.zhangcm.bean.Student)
	 */
	@Override
	public void updateStudent(Student student){
		try(SqlSession session = BaseService.openSession()){
			StudentDao sdao = session.getMapper(StudentDao.class);
			sdao.updateStudent(student);
			session.commit();
		}
	}
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.StudentService#findAllByClassId(java.lang.Long)
	 */
	@Override
	public List findAllByClassId(Long class_id){
		try(SqlSession session = BaseService.openSession()){
			StudentDao sdao = session.getMapper(StudentDao.class);
			return sdao.findAllByClassId(class_id);
		}
	}
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.StudentService#findById(java.lang.Long)
	 */
	@Override
	public Student findById(Long id){
		try(SqlSession session = BaseService.openSession()){
			StudentDao sdao = session.getMapper(StudentDao.class);
			return sdao.findById(id);
		}
	}
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.StudentService#findByNum(java.lang.String)
	 */
	@Override
	public Student findByNum(String num){
		try(SqlSession session = BaseService.openSession()){
			StudentDao sdao = session.getMapper(StudentDao.class);
			return sdao.findByNum(num);
		}
	}
	@Override
	public List findByMes(Student student){
		try(SqlSession session = BaseService.openSession()){
			StudentDao sdao = session.getMapper(StudentDao.class);
			return sdao.findByMes(student);
		}
	}
	
}
