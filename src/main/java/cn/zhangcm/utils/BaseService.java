package cn.zhangcm.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseService {
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
}
