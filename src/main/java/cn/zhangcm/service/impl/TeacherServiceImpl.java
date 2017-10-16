package cn.zhangcm.service.impl;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.zhangcm.bean.Teacher;
import cn.zhangcm.dao.TeacherDao;
import cn.zhangcm.service.TeacherService;
import cn.zhangcm.utils.BaseService;
import cn.zhangcm.utils.ExamException;

public class TeacherServiceImpl implements TeacherService {
	
	@Override
	public void addTeacher(Teacher t) {
		try (SqlSession session = BaseService.openSession();) {
			TeacherDao tdao = session.getMapper(TeacherDao.class);
			Teacher temp = tdao.findTeacherByEmail(t.getEmail());
			if (temp != null) {
				throw new ExamException("该邮箱有人使用");
			} else {
				tdao.addTeacher(t);
				session.commit();
			}
		}
	}
	
	@Override
	public void updateTeacher(Teacher t) {
		try (SqlSession session = BaseService.openSession()) {
			TeacherDao tdao = session.getMapper(TeacherDao.class);
			Teacher temp = tdao.findTeacherByEmail(t.getEmail());
			
			if (temp == null || temp.getId().equals(t.getId())) {
				System.out.println("nihao");
				tdao.updateTeacher(t);
				session.commit();
			} else {
				throw new ExamException("该邮箱已经有人使用");
			}
		}
	}

	@Override
	public void deleteTeacher(Long id) {
		try (SqlSession session = BaseService.openSession();) {
			TeacherDao tdao = session.getMapper(TeacherDao.class);
			Teacher temp = tdao.findTeacherById(id);
			if (temp == null) {
				throw new ExamException("�����ڸ��û�");
			} else {
				tdao.deleteTeacher(id);
				session.commit();
			}
		}
	}

	@Override
	public List<Teacher> getAll() {
		try (SqlSession session = BaseService.openSession();) {
			TeacherDao tdao = session.getMapper(TeacherDao.class);
			return tdao.findAll();
		}
	}

	@Override
	public Teacher getTeacherById(Long id) {
		try (SqlSession session = BaseService.openSession();) {
			TeacherDao tdao = session.getMapper(TeacherDao.class);
			return tdao.findTeacherById(id);
		}
	}

	@Override
	public Teacher getTeacherByEmail(String email) {
		try (SqlSession session = BaseService.openSession();) {
			TeacherDao tdao = session.getMapper(TeacherDao.class);
			return tdao.findTeacherByEmail(email);
		}
	}

	@Override
	public void updatePass(Long id, String oldPassword, String newPassword) {
		try (SqlSession session = BaseService.openSession();) {
			TeacherDao tdao = session.getMapper(TeacherDao.class);
			Teacher temp = tdao.findTeacherById(id);
			if (oldPassword.equals(temp.getPass())) {
				tdao.updatePassword(id, newPassword);
				session.commit();
			} else {
				throw new ExamException("ԭ����������������룡����");
			}
		}
		
	}

}
