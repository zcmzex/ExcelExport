package cn.zhangcm.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zhangcm.bean.ExamItem;
import cn.zhangcm.bean.Student;
import cn.zhangcm.bean.Teacher;
import cn.zhangcm.service.ClassesService;
import cn.zhangcm.service.ExamItemService;
import cn.zhangcm.service.StudentService;
import cn.zhangcm.service.TeacherService;
import cn.zhangcm.service.impl.ClassesServiceImpl;
import cn.zhangcm.service.impl.ExamItemServiceImpl;
import cn.zhangcm.service.impl.StudentServiceImpl;
import cn.zhangcm.service.impl.TeacherServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/login/deal.do")
public class LoginServlet extends HttpServlet {
	TeacherService ts = new TeacherServiceImpl();
	StudentService ss = new StudentServiceImpl();
	ClassesService cs = new ClassesServiceImpl();
	ExamItemService es = new ExamItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String method =RequestUtil.getString(req, "method");
		if("student".equals(method)){
			String loginnum = RequestUtil.getString(req, "loginnum");
			String pass = RequestUtil.getString(req, "pass");
			Student student = ss.findByNum(loginnum);
			req.getSession().setAttribute("student", student);
			req.setAttribute("student", student);
			//设置cookie值,可以用算法加密
			//Cookie cookie = new Cookie("stuloginnum",loginnum+pass);
			Cookie cookie = new Cookie("name", loginnum);
			//设置cookie的最大值
			cookie.setMaxAge(30*60);
			cookie.setPath("/exam");
			resp.addCookie(cookie);
			cookie = new Cookie("password",pass);
			cookie.setMaxAge(30*60);
			resp.addCookie(cookie);

			Long classid = student.getClassid();
			List<ExamItem> list = 
					es.findAllByClassId(classid);
			try {
				list = WebUtil.setExamState(list);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("list", list);
			WebUtil.forward(req, resp, "/index3.jsp");
			return;
		}
		String username = RequestUtil.getString(req, "username");
		String password = RequestUtil.getString(req, "pass");
		Teacher user = ts.getTeacherByEmail(username);
			HttpSession  session = req.getSession();
			session.setAttribute("user",user);
			if(req.getParameter("isremember")!=null){
				Cookie cookie = new Cookie("user", username);
				cookie.setMaxAge(30*60);
				resp.addCookie(cookie);
			}
			WebUtil.redirect(req, resp, "/index2.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
