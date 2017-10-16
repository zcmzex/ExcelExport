package cn.zhangcm.bean;

import java.util.ArrayList;
import java.util.List;

public class Question{
	
	private long id;
	//���
	private String con;
	//ѡ��
	private List<Item> list = new ArrayList();
	
	private int type;
	//��Ŀ
	private Subject subject;
	
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	private String subject_id;
	
	private String teacher_id;
	//������
	private Teacher teacher;
	//��Ŀ״̬
	private int stuts;
	//题目类型
	private String desrType;
	//题目状态
	private String desrStuts;
	/*@
	 * setter
	 * getter
	 * 
	 */
	
	public long getId() {
		return id;
	}
	public String getDesrType() {
		return desrType;
	}
	public void setDesrType(int type) {
		if(type==0){
			this.desrType = "单选题";
			return;
		}else{
			this.desrType = "多选题";
		}

	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", con=" + con + ", list=" + list
				+ ", type=" + type + ", subject=" + subject + ", subject_id="
				+ subject_id + ", teacher_id=" + teacher_id + ", teacher="
				+ teacher + ", stuts=" + stuts + ", desrType=" + desrType
				+ ", desrStuts=" + desrStuts + "]";
	}
	public String getDesrStuts() {
		return desrStuts;
	}
	public void setDesrStuts(int stuts) {
		if(stuts==0){
			this.desrStuts = "禁用";
			return;
		}else{
			this.desrStuts = "正常";
		}
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public List<Item> getList() {
		return list;
	}
	public void setList(List<Item> list) {
		this.list = list;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		setDesrType(type);
		this.type = type;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public int getStuts() {
		return stuts;
	}
	public void setStuts(int stuts) {
		setDesrStuts(stuts);
		this.stuts = stuts;
	}

	
	
}
