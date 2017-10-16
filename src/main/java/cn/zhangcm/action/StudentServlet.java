package cn.zhangcm.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import cn.zhangcm.service.ClassesService;
import cn.zhangcm.service.StudentService;
import cn.zhangcm.service.impl.ClassesServiceImpl;
import cn.zhangcm.service.impl.StudentServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/student/deal.do")
public class StudentServlet extends HttpServlet {
	private ClassesService cs = new ClassesServiceImpl();
	private StudentService ss = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String method = RequestUtil.getString(req, "method");
			if("list".equals(method)){
				list(req,resp);
				return;
			}
			if("getStudent".equals(method)){
				getStudent(req,resp);
				return;
			}
			if("add".equals(method)){
				add(req,resp);
				return;
			}
			if("addDeal".equals(method)){
				try {
					try {
						addDeal(req,resp);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	
	private void addDeal(HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, InvocationTargetException, ServletException, IOException, ParseException {
		Student stu = new Student();
		String dateStr = req.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		String name = req.getParameter("name");
		stu.setName(name);
		String sex = req.getParameter("sex");
		stu.setSex(Integer.parseInt(sex));
		stu.setClassid(Long.parseLong(req.getParameter("class_id")));
		stu.setLoginnum(req.getParameter("loginnum"));
		stu.setDate(date);
		ss.addStudent(stu);
		WebUtil.forward(req, resp, "/student/deal.do?method=list");
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Classes> list = cs.findAll();
		req.setAttribute("list", list);
		WebUtil.forward(req, resp, "/student/add.jsp");
	}

	private void getStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String classid = req.getParameter("identify");
			String name = RequestUtil.getString(req, "name");
			String loginnum = RequestUtil.getString(req, "loginnum");
			name = name.trim()==null?"%%":"%"+name+"%";
			loginnum = loginnum.trim()==null?"%%":"%"+loginnum+"%";
			Student stu = new Student();
			stu.setClassid(Long.parseLong(classid));
			System.out.println(Long.parseLong(classid)+"---------------------------");
			stu.setLoginnum(loginnum);
			stu.setName(name);
			List<Student> list = ss.findByMes(stu);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/student/allstudent.jsp").forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Classes> list = cs.findAll();
		for(Classes classs : list){
			System.out.println(classs.toString());
		}
		req.setAttribute("classlist", list);
		WebUtil.forward(req, resp, "/student/list.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
