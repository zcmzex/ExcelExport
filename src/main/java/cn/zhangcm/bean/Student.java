package cn.zhangcm.bean;

import java.util.Date;



//学生 学生名称，id，登录密码，性别，所属班级，登录学号，状态
public class Student {
	//学生id
	private Long id;
	//学生姓名
	private String name;
	//学生学号
	private String loginnum;
	//登录密码
	private String pass;
	//性别
	private int sex;
	//性别描述
	private String sexdesr;
	//班级id
	private long classid;
	//考试成绩
	private String grade;
	//出生日期
	private Date date;
	
	public String getGrade() {
		return grade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setSexdesr(String sexdesr) {
		this.sexdesr = sexdesr;
	}

	public Long getId() {
		return id;
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

	public String getLoginnum() {
		return loginnum;
	}

	public void setLoginnum(String loginnum) {
		this.loginnum = loginnum;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
		setSexdesr(sex);
	}

	public String getSexdesr() {
		return sexdesr;
	}

	public void setSexdesr(int sex) {
		if(sex == 0){
			this.sexdesr = "女";
			return;
		}
		this.sexdesr = "男";
	}

	public long getClassid() {
		return classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", loginnum="
				+ loginnum + ", pass=" + pass + ", sex=" + sex + ", sexdesr="
				+ sexdesr + ", class_id=" + classid + ", grade=" + grade
				+ ", date=" + date + "]";
	}

	
}
