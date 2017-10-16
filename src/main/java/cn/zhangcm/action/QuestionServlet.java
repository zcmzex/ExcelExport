package cn.zhangcm.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.zhangcm.bean.Item;
import cn.zhangcm.bean.Question;
import cn.zhangcm.bean.Subject;
import cn.zhangcm.bean.Teacher;
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

@WebServlet("/question/deal.do")
public class QuestionServlet extends HttpServlet {
	QuestionService qs = new QuestionServiceImpl();
	SubjectService ss = new SubjectServiceImpl();
	ItemService is = new ItemServiceImpl();
	TeacherService ts = new TeacherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = RequestUtil.getString(req, "method");
		if ("sub_list".equals(method)) {
			sub_list(req, resp);
		}
		if ("sub_que".equals(method)) {
			sub_que(req, resp);
		}
		if ("update".equals(method)) {
			update(req, resp);
		}
		if ("change".equals(method)) {
			change(req, resp);
		}
		if("sub_tea_all".equals(method)){
			sub_tea_all(req,resp);
		}
		if("add".equals(method)){
			add(req,resp);
		}
		if("que_item".equals(method)){
			que_item(req,resp);
		}
	}

	private void que_item(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sub_id = RequestUtil.getString(req, "sub_id");
		System.out.println(sub_id+"+++++++++++++++++++++++++++++++++");
		String que_id = RequestUtil.getString(req, "que_id");
		System.out.println(que_id+"--------------------------------------");
		Question question = qs.findById(Long.parseLong(que_id));
		List<Item> itemlist = question.getList();
		req.setAttribute("question", question);
		req.setAttribute("itemlist", itemlist);
		req.setAttribute("sub_id", sub_id);
		WebUtil.forward(req, resp, "/question/que_item.jsp");
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subject_id = RequestUtil.getString(req, "subject");
		String teacher_id = RequestUtil.getString(req, "teacher");
		String itemcons[] = req.getParameterValues("itemcon");
		String istrues[] = req.getParameterValues("istrue");
		List istruelist = Arrays.asList(istrues);
		int iss[] = new int[4] ;
		for(int i= 1;i<5;i++){
			if(istruelist.contains(String.valueOf(i))){
				iss[i-1] = 1;
			}
			else{
				iss[i-1] = 0;
			}
		}
		Question question = new Question();
		question.setSubject_id(subject_id);
		question.setTeacher_id(teacher_id);
		try {
			String con = req.getParameter("con");
			String type = req.getParameter("quetype");
			question.setCon(con);
			question.setType(Integer.parseInt(type));
			qs.addQuestion(question);
			
			Long id = question.getId();
			for(int i = 0;i<4;i++){
				Item item = new Item();
				item.setCon(itemcons[i]);
				item.setQuestion_id(id.toString());
				item.setIstrue(iss[i]);
				is.addItem(item);
			}
			req.setAttribute("message", "添加成功");
			WebUtil.redirect(req, resp, "/question/deal.do?method=que_item&sub_id="+subject_id+"&que_id="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void sub_tea_all(HttpServletRequest req, HttpServletResponse resp) {
		List<Teacher> tea_list = ts.getAll();
		List<Subject> sub_list = ss.findAll();
		req.setAttribute("tea_list", tea_list);
		req.setAttribute("sub_list", sub_list);
		try {
			WebUtil.forward(req, resp, "/question/add.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//更新所有选项
		updateItem(req, resp);
		//得到要更新的试题
		String que_id = RequestUtil.getString(req, "id");
		Question question = qs.findById(Long.parseLong(que_id));
		//得到试题更新的参数，更新试题
		try {
			BeanUtils.populate(question, req.getParameterMap());
			qs.update(question);
			WebUtil.redirect(req, resp, "/question/deal.do?method=sub_list");
		}catch(IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updateItem(HttpServletRequest req, HttpServletResponse resp){
		// 先得到要更新的题目
		String que_id = RequestUtil.getString(req, "id");
		Question question = qs.findById(Long.parseLong(que_id));
		// 得到从表单提交的选项
		// 得到选项内容
		String[] itemcons = req.getParameterValues("itemcon");
		// 得到选项id
		String[] itemids = req.getParameterValues("itemid");
		// 得到正确的选项
		String[] istruesid = req.getParameterValues("istrue");
		
		// 封装到选项中
		// 创建选项集合
		List<Item> itemlists = new ArrayList();
		// 循环得到选项
		for (int i = 0; i < itemcons.length; i++) {
			// 从数据库得到要更新的选项
			Item item = is.findById(Long.parseLong(itemids[i]));
			item.setCon(itemcons[i]);
			itemlists.add(item);
		}
		// 为选项设置正确与错误
		for (Item item : itemlists) {
			if (Arrays.asList(istruesid).contains(String.valueOf(item.getId()))) {
				item.setIstrue(1);
			} else {
				item.setIstrue(0);
			}
		}
		//更新选项
		for(Item item : itemlists){
			is.update(item);
		}
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		String id = RequestUtil.getString(req, "id");
		// 找到要更新的问题以及所有的选项
		Question question = qs.findById(Long.parseLong(id));
		// 放进request域
		req.setAttribute("question", question);
		// 转到update.jsp
		try {
			WebUtil.forward(req, resp, "update.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
			WebUtil.forward(req, resp, "sub_que.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sub_list(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("1234553434------------------------------------------");
		List<Subject> sub_list = ss.findAll();
		req.setAttribute("sub_list", sub_list);
		try {
			WebUtil.forward(req, resp, "sub_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
