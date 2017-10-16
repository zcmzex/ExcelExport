package cn.zhangcm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zhangcm.bean.Item;
import cn.zhangcm.dao.ItemDao;
import cn.zhangcm.service.ItemService;
import cn.zhangcm.utils.BaseService;

public class ItemServiceImpl implements ItemService {
	/*
	 * ���һ��ѡ��
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ItemService#addItem(cn.zhangcm.bean.Item)
	 */
	@Override
	public void addItem(Item item){
		try(SqlSession session = BaseService.openSession()){
			ItemDao idao = session.getMapper(ItemDao.class);
			idao.add(item);
			session.commit();
		}
	}
		public Item findById(Long id){
			try(SqlSession session = BaseService.openSession()){
				ItemDao idao = session.getMapper(ItemDao.class);
				return idao.findById(id);
			}
		}
	/*
	 * ɾ��һ��ѡ��
	 */
//	public void delete(Long id){
//		try(SqlSession session = BaseService.openSession()){
//			ItemDao idao = session.getMapper(ItemDao.class);
//			idao.delete(id);
//			session.commit();
//		}
//	}
	/*
	 * Ѱ��һ��ѡ��
	 */
//	public Item findById(Long id){
//		try(SqlSession session = BaseService.openSession()){
//			ItemDao idao = session.getMapper(ItemDao.class);
//			return idao.findById(id);
//		}
//	}
	/*
	 * �Ҹ�ĳ����Ŀ������ѡ��
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ItemService#findAllByQuestionId(java.lang.Long)
	 */
	@Override
	public List findAllByQuestionId(Long id){
		try(SqlSession session = BaseService.openSession()){
			ItemDao idao = session.getMapper(ItemDao.class);
			return idao.findByQuestionId(id);
		}
	}
	/*
	 * ����һ��ѡ��
	 */
	/* (non-Javadoc)
	 * @see cn.zhangcm.service.impl.ItemService#update(cn.zhangcm.bean.Item)
	 */
	@Override
	public void update(Item item){
		try(SqlSession session = BaseService.openSession()){
			ItemDao idao = session.getMapper(ItemDao.class);
			idao.update(item);
			session.commit();
		}
		
	}
}
