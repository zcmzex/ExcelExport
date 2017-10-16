package exam;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.zhangcm.bean.Question;
import cn.zhangcm.dao.QuestionDao;

public class Test1 {
	  private static SqlSessionFactory sqlSessionFactory;
	   private static Reader reader; 
	   
	   static{
	        try{
	            reader = Resources.getResourceAsReader("Configuration.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	   
	   public static SqlSession openSession(){
		   return sqlSessionFactory.openSession();
	   }
	@Test
	public void demo1(){
		SqlSession session = openSession();
		QuestionDao qdao = session.getMapper(QuestionDao.class);
		Question question = qdao.findById(1L);
		System.out.println(question.getTeacher());
		System.out.println(question.getSubject());
	}
}
