package cn.zhangcm.bean;

public class Item {
	
	private long id;
	//ѡ������
	private String con;
	//�Ƿ���ȷ
	private int istrue;
	//������Ŀ
	private Question question;
	
	private String question_id;
	
	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", con=" + con + ", istrue=" + istrue + ", question=" + question + "]";
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public int getIstrue() {
		return istrue;
	}

	public void setIstrue(int istrue) {
		this.istrue = istrue;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
