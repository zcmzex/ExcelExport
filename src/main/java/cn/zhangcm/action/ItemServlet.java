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

import cn.zhangcm.bean.Item;
import cn.zhangcm.bean.Question;
import cn.zhangcm.bean.Subject;
import cn.zhangcm.service.ItemService;
import cn.zhangcm.service.QuestionService;
import cn.zhangcm.service.SubjectService;
import cn.zhangcm.service.TeacherService;
import cn.zhangcm.service.impl.ItemServiceImpl;
import cn.zhangcm.service.impl.QuestionServiceImpl;
import cn.zhangcm.service.impl.SubjectServiceImpl;
import cn.zhangcm.service.impl.TeacherServiceImpl;
import cn.zhangcm.utils.RequestUtil;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/item/deal.do")
public class ItemServlet extends HttpServlet {
	QuestionService qs = new QuestionServiceImpl();
	SubjectService ss = new SubjectServiceImpl();
	ItemService is = new ItemServiceImpl();
	TeacherService ts = new TeacherServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = RequestUtil.getString(req, "method");
		if("add".equals(method)){
			add(req,resp);
		}
		if("getQue".equals(method)){
			getQue(req,resp);
		}
		if("sub_all".equals(method)){
			sub_all(req,resp);
		}
		if("sub_que".equals(method)){
			sub_que(req,resp);
		}
		if("adddeal".equals(method)){
			adddeal(req,resp);
		}
	}

	private void adddeal(HttpServletRequest req, HttpServletResponse resp)  {
		String id = RequestUtil.getString(req, "subject_id");
		Item item = new Item();
		try {
			BeanUtils.populate(item, req.getParameterMap());
			is.addItem(item);
			req.setAttribute("sub_id", id);
			req.setAttribute("message", "添加选项成功");
			WebUtil.forward(req, resp, "/item/add_mes.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sub_que(HttpServletRequest req, HttpServletResponse resp) {
		// 得到要获取试题的科目id
				String sub_id = RequestUtil.getString(req, "sub_id");
				Subject subject = ss.findById(Long.parseLong(sub_id));
				// 根据id得到所有试题
				List<Question> que_list = subject.getList();
				req.setAttribute("que_list", que_list);
				req.setAttribute("subject", subject);
				try {
					WebUtil.forward(req, resp, "/item/que_list.jsp");
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	private void sub_all(HttpServletRequest req, HttpServletResponse resp) {
		List<Subject> sub_list = ss.findAll();
		req.setAttribute("sub_list", sub_list);
		try {
			WebUtil.forward(req, resp, "/item/sub_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getQue(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		String sub_id = RequestUtil.getString(req, "id");
		Subject subject = ss.findById(Long.valueOf(sub_id));
		List<Question> que_list = subject.getList();
		System.out.println(que_list);
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		//要添加的选项的题目id
		String id = RequestUtil.getString(req, "id");
		//得到该题目
		Question question = qs.findById(Long.parseLong(id));
		req.setAttribute("question_id", id);
		try {
			WebUtil.forward(req, resp, "/item/additem.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
