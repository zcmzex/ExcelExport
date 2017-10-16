package cn.zhangcm.service;

import java.util.List;

import cn.zhangcm.bean.Item;

public interface ItemService {

	/*
	 * ���һ��ѡ��
	 */
	public abstract void addItem(Item item);

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

	/*
	 * �Ҹ�ĳ����Ŀ������ѡ��
	 */
	public abstract List findAllByQuestionId(Long id);

	/*
	 * ����һ��ѡ��
	 */
	public abstract void update(Item item);
	public abstract Item findById(Long id);
}