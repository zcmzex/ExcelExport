package cn.zhangcm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zhangcm.bean.Question;
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
@WebServlet("/exam/deal.do")
public class ExamServlet extends HttpServlet {
	TeacherService ts = new TeacherServiceImpl();
	StudentService ss = new StudentServiceImpl();
	ClassesService cs = new ClassesServiceImpl();
	ExamItemService es = new ExamItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String subjectid = RequestUtil.getString(req, "subjectid");
		String radionum = RequestUtil.getString(req, "radionum");
		String checknum = RequestUtil.getString(req, "checknum");
		String checkfen = RequestUtil.getString(req, "checkfen");
		String radiofen = RequestUtil.getString(req, "radiofen");
		int rnum = Integer.parseInt(radionum);
		int cnum = Integer.parseInt(checknum);
		int num = rnum + cnum;
		List<Question> list = WebUtil.createQue(subjectid, rnum, cnum);
		req.getSession().setAttribute("queexamlist", list);
		HttpSession session = req.getSession();
		session.setAttribute("checkfen", checkfen);
		session.setAttribute("radiofen", radiofen);
		req.setAttribute("subjectid", subjectid);
		req.setAttribute("num", num);
		WebUtil.forward(req, resp, "/exam.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
