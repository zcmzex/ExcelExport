package cn.zhangcm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zhangcm.bean.Student;
import cn.zhangcm.service.ClassesService;
import cn.zhangcm.service.ExamItemService;
import cn.zhangcm.service.StudentService;
import cn.zhangcm.service.TeacherService;
import cn.zhangcm.service.impl.ClassesServiceImpl;
import cn.zhangcm.service.impl.ExamItemServiceImpl;
import cn.zhangcm.service.impl.StudentServiceImpl;
import cn.zhangcm.service.impl.TeacherServiceImpl;
import cn.zhangcm.utils.RequestUtil;
@WebServlet("/checkstu/deal.do")
public class CheckStuServlet extends HttpServlet {
	TeacherService ts = new TeacherServiceImpl();
	StudentService ss = new StudentServiceImpl();
	ClassesService cs = new ClassesServiceImpl();
	ExamItemService es = new ExamItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginnum = RequestUtil.getString(req, "loginnum");
		String pass = RequestUtil.getString(req, "pass");
		Student student = ss.findByNum(loginnum);
		if(student==null){
			resp.getWriter().print("用戶名不存在");
		}
		else if(!pass.equals(student.getPass())){
			resp.getWriter().print("用戶密码错误");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
