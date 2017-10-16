package cn.zhangcm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.zhangcm.bean.ExamItem;
import cn.zhangcm.bean.Item;
import cn.zhangcm.bean.Question;
import cn.zhangcm.service.ClassesService;
import cn.zhangcm.service.ExamItemService;
import cn.zhangcm.service.ItemService;
import cn.zhangcm.service.QuestionService;
import cn.zhangcm.service.StudentService;
import cn.zhangcm.service.TeacherService;
import cn.zhangcm.service.impl.ClassesServiceImpl;
import cn.zhangcm.service.impl.ExamItemServiceImpl;
import cn.zhangcm.service.impl.ItemServiceImpl;
import cn.zhangcm.service.impl.QuestionServiceImpl;
import cn.zhangcm.service.impl.StudentServiceImpl;
import cn.zhangcm.service.impl.TeacherServiceImpl;

public class WebUtil {
	private static TeacherService ts = new TeacherServiceImpl();
	private static StudentService ss = new StudentServiceImpl();
	private static ItemService is = new ItemServiceImpl();
	private static ClassesService cs = new ClassesServiceImpl();
	private static ExamItemService es = new ExamItemServiceImpl();
	private static QuestionService qs = new QuestionServiceImpl();
	public static void forward(HttpServletRequest req,
			HttpServletResponse resp, String url) throws ServletException,
			IOException {
		url = resp.encodeURL(url);
		req.getRequestDispatcher(url).forward(req, resp);
	}
	public static List setExamState(List<ExamItem> list) throws ParseException{
		List<ExamItem> lists = new ArrayList();
		for(ExamItem item:list){
			String etime = item.getEtime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(etime);
			if(new Date().getTime()>date.getTime()){
				item.setState(1);
			}
			lists.add(item);
		}
		return lists;
	}
	//得到上传文件路径
	public static String uploadFile(HttpServletRequest request,
			HttpServletResponse response){
		String filepath = null;
		//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
		File file = new File(savePath);
		//判断上传文件的保存目录是否存在
		if (!file.exists() && !file.isDirectory()) {
		System.out.println(savePath+"目录不存在，需要创建");
		//创建目录
		file.mkdir();
		}
		try{
		//使用Apache文件上传组件处理文件上传步骤：
		//1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8"); 
		//3、判断提交上来的数据是否是上传表单的数据
		if(!upload.isMultipartContent(request)){
		//按照传统方式获取数据
		return "das";
		}
		//4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		List<FileItem> list = upload.parseRequest(request);
		for(FileItem item : list){
		//如果fileitem中封装的是普通输入项的数据
		if(item.isFormField()){
		String name = item.getFieldName();
		//解决普通输入项的数据的中文乱码问题
		String value = item.getString("UTF-8");
		//value = new String(value.getBytes("iso8859-1"),"UTF-8");
		System.out.println(name + "=" + value);
		}else{//如果fileitem中封装的是上传文件
		//得到上传的文件名称，
		String filename = item.getName();
		System.out.println(filename);
		if(filename==null || filename.trim().equals("")){
		continue;
		}
		//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
		//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
		filename = filename.substring(filename.lastIndexOf("\\")+1);
		//获取item中的上传文件的输入流
		InputStream in = item.getInputStream();
		//创建一个文件输出流
		filepath = savePath + "\\" + filename;
		System.out.println(filepath);
		System.out.println(savePath);
		FileOutputStream out = new FileOutputStream(filepath);
		//创建一个缓冲区
		byte buffer[] = new byte[1024];
		//判断输入流中的数据是否已经读完的标识
		int len = 0;
		//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
		while((len=in.read(buffer))>0){
		//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
		out.write(buffer, 0, len);
		}
		//关闭输入流
		in.close();
		//关闭输出流
		out.close();
		//删除处理文件上传时生成的临时文件
		item.delete();
		
		}
		}
		}catch (Exception e) {
		e.printStackTrace();
		 
		}
		return filepath;
	}
	public static void redirect(HttpServletRequest req,
			HttpServletResponse resp, String url) throws IOException {
		if (url.startsWith("/")) {
			url = req.getServletContext().getContextPath() + url;
		}
		url = resp.encodeRedirectURL(url);
		resp.sendRedirect(url);
		// 如果是服务器处理 / 就代表项目根，如果是浏览器处理，就是服务器根路径
	}

	public static void redirect(HttpServletResponse resp, String url)
			throws IOException {
		url = resp.encodeRedirectURL(url);
		resp.sendRedirect(url);
	}
	//创建试题
	public static List createQue(String subid,int rnum,int cnum){
		List<Question> list = new ArrayList();
		List<Question> radiolist = qs.findAllByTypeAndSub(0, subid);
		int rnummax = radiolist.size();
		List<Question> checklist = qs.findAllByTypeAndSub(1, subid);
		int cnummax = checklist.size();
		//如果需要的试题数量大于等于最大试题数
		if(rnum>=rnummax){
			rnum = rnummax;
		}
		if(cnum>=cnummax){
			cnum = cnummax;
		}
		List<Integer> rrand = getRandom(rnummax+1, rnum);
		List<Integer> crand = getRandom(cnummax+1, cnum);
		//创建单选
		for(int i = 0;i<rnum;i++){
			list.add(radiolist.get(rrand.get(i)-1));
		}
		//创建多选
		for(int i = 0;i<cnum;i++){
			list.add(checklist.get(crand.get(i)-1));
		}
		return list;
	}
	public static List getRandom(int max,int num){
		Random random = new Random();
		List<Integer> list = new ArrayList();
		//生成单选题随机数
		for(int i = 0;i<num;i++){
			int randrnum = random.nextInt(max);
			if(randrnum == 0){
				i--;
				continue;
			}
			boolean s = true;
			//遍历列表，如果有相同的，设置为false
			for(int index : list){
				if(index==randrnum){
					s = false;
				}
			}
			if(s){
				list.add(randrnum);
			}else{
				i--;
			}
		}
		return list;
	}
	//得到考试成绩
	public static int getGrade(String arr, String arr2,HttpServletRequest req) {
		String arrs1[] = arr.split(",");
		String arrs2[] = arr2.split(",");
		int grade = 0;
		int radiofen = Integer.parseInt((String) req.getSession().getAttribute("radiofen"));
		int checkfen = Integer.parseInt((String) req.getSession().getAttribute("checkfen"));
		//处理单选题
		Map<Long,Long> map = new HashMap();
		for(String str : arrs1){
			String s[] = str.split(":");
			map.put(Long.parseLong(s[0]), Long.parseLong(s[1]));
		}
		//得到试题
		for(Map.Entry<Long, Long> entry : map.entrySet()){
			Item item = is.findById(entry.getValue());
			if(item.getIstrue()==1){
				grade += radiofen;
			}
		}
		//处理多选试题
		Map<Long,Long[]> map2 = new HashMap();
		Set<Long> set = new HashSet();
		//得到试题的id
		for(String str : arrs2){
			if(str!=null||str!=""){
				String s[] = str.split(":");
				set.add(Long.parseLong(s[0]));
			}
		}	
		//将试题和选项封装起来
		for(Long l : set){
			List<Long> list = new ArrayList();
			for(String str : arrs2){
				if(str!=null||str!=""){
					String s[] = str.split(":");
					if(l == Long.parseLong(s[0])){
						list.add(Long.parseLong(s[1]));
					}
				}
			}	
			Long[] nel = new Long[list.size()];
			for(int i = 0;i<list.size();i++){
				nel[i] = list.get(i);
			}
			map2.put(l,nel);
		}
		for(Map.Entry<Long, Long[]> entry : map2.entrySet()){
			List<Long> list = new ArrayList();
			Question question = qs.findById(entry.getKey());
			List<Item> items = question.getList();
			//正确选项的id
			for(Item item : items){
				if(item.getIstrue()==1){
					list.add(item.getId());
				}
			}
			for(Long l : list){
				if(!Arrays.asList(entry.getValue()).contains(l)){
					break;
				}
			}
			grade += checkfen;
		}
		return grade;
	}
}
