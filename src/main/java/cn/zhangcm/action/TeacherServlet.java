package cn.zhangcm.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.zhangcm.bean.Teacher;
import cn.zhangcm.service.TeacherService;
import cn.zhangcm.service.impl.TeacherServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/teacher/deal.do")
public class TeacherServlet extends HttpServlet {
	private TeacherService ts = new TeacherServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = RequestUtil.getString(req, "method");
		if("list".equals(method)){
			list(req,resp);
		}
		if("update".equals(method)){
			update(req,resp);
		}
		if("change".equals(method)){
			change(req,resp);
		}
		if("add".equals(method)){
			add(req,resp);
		}

	}



	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Teacher t = new Teacher();
		try {
			BeanUtils.populate(t, req.getParameterMap());
			ts.addTeacher(t);
			req.setAttribute("message", "添加成功");
			WebUtil.forward(req, resp, "deal.do?method=list");
		} catch (Exception e) {
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，添加老师信息失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/error.jsp");
		} 
	}
	private void change(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
		String id = RequestUtil.getString(req, "id");
		Teacher t = ts.getTeacherById(Long.parseLong(id));
		try {
			BeanUtils.populate(t, req.getParameterMap());
			ts.updateTeacher(t);
			WebUtil.redirect(req, resp, "/teacher/deal.do?method=list");
		} catch (Exception e) {
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，更新老师信息失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/error.jsp");
		} 
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = RequestUtil.getString(req, "id");
		Teacher t = ts.getTeacherById(Long.parseLong(id));
		req.setAttribute("teacher", t);
		try {
			WebUtil.forward(req, resp, "update.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，获取老师信息失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/exam/error.jsp");
		} 
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Teacher> list = ts.getAll();
		req.setAttribute("list", list);
		try{
		WebUtil.forward(req, resp, "list.jsp");
		}catch(Exception e){
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，获取老师列表失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/error.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
}
