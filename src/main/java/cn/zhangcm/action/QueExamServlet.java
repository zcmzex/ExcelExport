package cn.zhangcm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zhangcm.bean.Item;
import cn.zhangcm.bean.Question;
import cn.zhangcm.utils.WebUtil;
@WebServlet("/queexam/deal.do")
public class QueExamServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String index = req.getParameter("index");
			HttpSession session = req.getSession();
			List<Question> list = (List<Question>) session.getAttribute("queexamlist");
			Question question = list.get(Integer.parseInt(index)-1);
			List<Item> Itemlist = question.getList();
			req.setAttribute("itemList",Itemlist);
			req.setAttribute("question", question);
			req.setAttribute("index", Integer.parseInt(index));
			WebUtil.forward(req, resp, "/que.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
