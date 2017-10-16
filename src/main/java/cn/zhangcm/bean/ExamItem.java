package cn.zhangcm.bean;
public class ExamItem {
		
	private long id;
	
	private String stime;
	
	private String etime;
	
	private String classid;
	
	private String subjectid;
	
	private int radionum;
	
	private int radiofen;
	
	private int checknum;
	
	private int checkfen;
	
	private int state;
	
	private String stateDesr;
	
	private Subject subject;
	
	private Classes classes;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClsses(Classes classes) {
		this.classes = classes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public int getRadionum() {
		return radionum;
	}

	public void setRadionum(int radionum) {
		this.radionum = radionum;
	}

	public int getRadiofen() {
		return radiofen;
	}

	public void setRadiofen(int radiofen) {
		this.radiofen = radiofen;
	}

	public int getChecknum() {
		return checknum;
	}

	public void setChecknum(int checknum) {
		this.checknum = checknum;
	}

	public int getCheckfen() {
		return checkfen;
	}

	public void setCheckfen(int checkfen) {
		this.checkfen = checkfen;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		setStateDesr(state);
		this.state = state;
	}

	public String getStateDesr() {
		return stateDesr;
	}

	public void setStateDesr(int state) {
		if(state == 0){			
			this.stateDesr = "作废";
			return;
		}
		if(state == 1){
			this.stateDesr = "已考完";
			return;
		}
		if(state == 2){
			this.stateDesr = "考试中";
			return;
		}
		
	}
	
}
