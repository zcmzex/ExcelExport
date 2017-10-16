package cn.zhangcm.bean;

public class Teacher {
	//��ʦid
	private Long id ;
	//��ʦ����
	private String name;
	//��ʦ����
	private String pass;
	//��ʦ������
	private String email;
	//��ʦְ��
	private String title;
	//��ʦ�ֻ��
	private String phone;
	//��ʦ����
	private int age;
	//��ʦ״̬
	private int state;
	//状态描述
	private String desrState ;
	
	public String getDesrState() {
		return desrState;
	}
	public void setDesrState(int i) {
		if(i == 0){
			this.desrState = "离职";
			return ;
		}
		this.desrState ="在职";
	}
	/**
	 * setter
	 * getter
	 * @return
	 */
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", pass=" + pass + ", email=" + email + ", title=" + title
				+ ", phone=" + phone + ", age=" + age + ", state=" + state + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		setDesrState(state);
		this.state = state;
	}
}
