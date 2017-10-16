package cn.zhangcm.dao;

import java.util.List;

import cn.zhangcm.bean.Item;
import cn.zhangcm.bean.Question;

public interface ItemDao {
	
	void add(Item item);
	
	void delete(Long id);
	
	void update(Item item);
	
	//List<Item> findAll();
	Item findById(Long id);
	
	
	List<Item> findByQuestionId(Long id);
}
