package cn.zhangcm.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zhangcm.bean.Student;
import cn.zhangcm.service.StudentService;
import cn.zhangcm.service.impl.StudentServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/examdeal/deal.do")
public class ExamDealServlet extends HttpServlet {
	StudentService ss = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String arr = RequestUtil.getString(req,"arr");
			String arr2 = RequestUtil.getString(req, "arr2");
			int grade = WebUtil.getGrade(arr,arr2,req);
			Student stu = (Student) req.getSession().getAttribute("student");
//			Date date = stu.getDate();
//			System.out.println(date);
			stu.setGrade(String.valueOf(grade));
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String str = sdf.format(date);
//			try {
//				date = sdf.parse(str);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			stu.setDate(date);
			ss.updateStudent(stu);
			resp.getWriter().print("考试得分:"+grade);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doGet(req,resp);
	}
}
