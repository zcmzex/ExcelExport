package cn.zhangcm.bean;

import java.util.ArrayList;
import java.util.List;

//班级 班级名称，id，班级的创建者（现在登录者），班级的学生，状态
public class Classes {
	//班级id
	private long id;
	//班级名称
	private String name;
	//学生列表
	private List<Student> list = new ArrayList();
	//班级类型
	private int type;
	//班级描述
	private String typedesr;
	//创建者id
	private long create_id;
	//状态
	private int state;
	//状态描述
	private String stateDesr;
	
	public long getId() {
		return id;
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
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		setTypedesr(type);
		this.type = type;
	}
	public String getTypedesr() {
		return typedesr;
	}
	public void setTypedesr(int type) {
		if(type == 0){
			this.typedesr = "专科";
			return;
		}
		this.typedesr = "本科";
	}
	public long getCreate_id() {
		return create_id;
	}
	public void setCreate_id(long teacher_id) {
		this.create_id = teacher_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
		setStateDesr(state);
	}
	public String getStateDesr() {
		return stateDesr;
	}
	public void setStateDesr(int state) {
		if(state == 0){
			this.stateDesr = "毕业";
			return;
		}
		this.stateDesr = "在校";
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", list=" + list
				+ ", type=" + type + ", typedesr=" + typedesr + ", create_id="
				+ create_id + ", state=" + state + ", stateDesr=" + stateDesr
				+ "]";
	}
	
	
}
