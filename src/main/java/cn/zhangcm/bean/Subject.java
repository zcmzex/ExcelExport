package cn.zhangcm.bean;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private long id;
	// ��Ŀ��
	private String name;
	// ѧ��
	private String credit;
	// ��Ŀ��״̬
	private int stuts;
	// ��Ŀ��ӵ�е���
	private List<Question> list = new ArrayList();
	// 状态描述
	private String descStuts;

	/*
	 * @ setter getter
	 */

	public long getId() {
		return id;
	}

	public String getDescStuts() {
		return descStuts;
	}

	public void setDescStuts(int i) {
		if (i == 0) {
			this.descStuts = "禁用";
			return;
		} else {
			this.descStuts = "正常";
		}
	}

	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public int getStuts() {
		return stuts;
	}

	public void setStuts(int stuts) {
		setDescStuts(stuts);
		this.stuts = stuts;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", credit=" + credit
				+ ", stuts=" + stuts + "]";
	}

}
