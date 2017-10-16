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

import cn.zhangcm.bean.Subject;
import cn.zhangcm.service.SubjectService;
import cn.zhangcm.service.impl.SubjectServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/subject/deal.do")
public class SubjectServlet extends HttpServlet {
	SubjectService ss = new SubjectServiceImpl();
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
		Subject s = new Subject();
		try {
			BeanUtils.populate(s, req.getParameterMap());
			ss.addSubject(s);
			req.setAttribute("message", "添加科目成功");
			WebUtil.forward(req, resp, "deal.do?method=list");
		} catch (Exception e) {
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，添加科目信息失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/error.jsp");
		}
		
	}

	private void change(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = RequestUtil.getString(req, "id");
		Subject s = ss.findById(Long.parseLong(id));
		try {
			BeanUtils.populate(s, req.getParameterMap());
			ss.update(s);
			WebUtil.forward(req, resp, "/subject/deal.do?method=list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，更新科目信息失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/error.jsp");
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = RequestUtil.getString(req, "id");
		Subject s = ss.findById(Long.parseLong(id));
		req.setAttribute("subject", s);
		System.out.println("-----"+s+"-----");
		try {
			WebUtil.forward(req, resp, "/subject/update.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，获取科目信息失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/error.jsp");
		} 
		
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Subject> list = ss.findAll();
		req.setAttribute("list", list);
		try {
			WebUtil.forward(req, resp, "/subject/list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			req.getServletContext().setAttribute("error", "抱歉，获取科目信息失败，请联系我们的后台人员");
			WebUtil.redirect(req, resp, "/error.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
