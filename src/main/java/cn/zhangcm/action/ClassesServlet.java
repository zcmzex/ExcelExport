package cn.zhangcm.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.zhangcm.bean.Classes;
import cn.zhangcm.bean.Student;
import cn.zhangcm.bean.Teacher;
import cn.zhangcm.service.ClassesService;
import cn.zhangcm.service.StudentService;
import cn.zhangcm.service.impl.ClassesServiceImpl;
import cn.zhangcm.service.impl.StudentServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/classes/deal.do")
public class ClassesServlet extends HttpServlet {
	private ClassesService cs = new ClassesServiceImpl();
	private StudentService ss = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = RequestUtil.getString(req, "method");
		if("cls_list".equals(method)){
			cls_list(req,resp);
			return;
		}
		if("update".equals(method)){
			update(req,resp);
			return;
		}
		if("getStudents".equals(method)){
			try {
				getStudents(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if("upload".equals(method)){
			try {
				upload(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if("change".equals(method)){
			try {
				change(req,resp);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if("add".equals(method)){
			try {
				add(req,resp);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	}
	private void getStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		String class_id = RequestUtil.getString(req, "id");
		String name = RequestUtil.getString(req, "name");
		List<Student> list = ss.findAllByClassId(Long.parseLong(class_id));
		List<Student> list2 = new ArrayList();
		req.setAttribute("list", list);
		req.setAttribute("name", name);
		WebUtil.forward(req, resp, "students.jsp");
	}
	private void upload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ParseException {
//		String filepath = WebUtil.uploadFile(req,resp);
//		System.out.println(filepath);
		String classid = RequestUtil.getString(req, "id");
		//BufferedReader reader = new BufferedReader(new FileReader(filepath));	
		BufferedReader reader = new BufferedReader(new FileReader("E://a.txt"));
		String str = null;
		//添加学生
		while((str = reader.readLine())!=null){
			str = str.trim();
			String [] strs = str.split(",");
			Student student = new Student();
			String name = strs[0];
			String date = strs[1];
			String sex = strs[2];
			String loginnum = strs[3];
			student.setClassid(Long.parseLong(classid));
			//日期和string的转化
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			Date date2 = sdf.parse(date);  
			student.setDate(date2);
			student.setLoginnum(loginnum);
			student.setName(name);
			student.setSex(Integer.parseInt(sex));
			student.setPass("123");
			ss.addStudent(student);
		}
		WebUtil.forward(req, resp, "deal.do?method=cls_list");
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String class_id = RequestUtil.getString(req, "id");
		Classes c = cs.findById(Long.parseLong(class_id));
		c.setId(Long.parseLong(class_id));
		req.setAttribute("classes", c);
		WebUtil.forward(req, resp, "update.jsp");
	}
	//添加班级
	private void add(HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		Long teacher_id = teacher.getId();
		System.out.println("teacher_id"+teacher_id);
		Classes classes = new Classes();
		BeanUtils.populate(classes, req.getParameterMap());
		classes.setCreate_id(teacher_id);
		System.out.println(classes);
		cs.addClasses(classes);
		WebUtil.forward(req, resp, "deal.do?method=cls_list");
	}
	//处理改变信息
	private void change(HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
		Classes classes = new Classes();
		String id = RequestUtil.getString(req, "id");
		BeanUtils.populate(classes, req.getParameterMap());
		classes.setId(Long.parseLong(id));
		System.out.println("------------"+classes);
		cs.updateClasses(classes);
		WebUtil.forward(req, resp, "deal.do?method=cls_list");
	}
	//得到班级列表
	private void cls_list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Classes> list = cs.findAll();
		req.setAttribute("list", list);
		WebUtil.forward(req, resp, "list.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}	
