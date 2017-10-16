package cn.zhangcm.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.zhangcm.bean.Classes;
import cn.zhangcm.bean.ExamItem;
import cn.zhangcm.bean.Subject;
import cn.zhangcm.service.ClassesService;
import cn.zhangcm.service.ExamItemService;
import cn.zhangcm.service.SubjectService;
import cn.zhangcm.service.impl.ClassesServiceImpl;
import cn.zhangcm.service.impl.ExamItemServiceImpl;
import cn.zhangcm.service.impl.SubjectServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/examitem/deal.do")
public class ExamItemServlet extends HttpServlet {
	ExamItemService es = new ExamItemServiceImpl();
	SubjectService ss = new SubjectServiceImpl();
	ClassesService cs = new ClassesServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = RequestUtil.getString(req, "method");
			if("list".equals(method)){
				list(req,resp);
				return;
			}
			if("add".equals(method)){
				add(req,resp);
				return;
			}
			if("addDeal".equals(method)){
				addDeal(req,resp);
				return;
			}
	}
	
	private void addDeal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ExamItem examitem = new ExamItem();
		try {
			BeanUtils.populate(examitem, req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.addExamItem(examitem);
		WebUtil.forward(req, resp, "deal.do?method=list");
		
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Classes> cla_list = cs.findAll();
			List<Subject> sub_list = ss.findAll();
			req.setAttribute("cla_list",cla_list);
			req.setAttribute("sub_list",sub_list);
			WebUtil.forward(req, resp, "/examitem/add.jsp");
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ExamItem> list = es.findAll();
		for(ExamItem item : list){
			String sub_id = item.getSubjectid();
			String cla_id = item.getClassid();
			Subject sub = ss.findById(Long.parseLong(sub_id));
			Classes cls = cs.findById(Long.parseLong(cla_id));
			item.setSubject(sub);
			item.setClsses(cls);
		}
		try {
			list = WebUtil.setExamState(list);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("list", list);
		WebUtil.forward(req, resp, "list.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
