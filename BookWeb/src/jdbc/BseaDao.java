package jdbc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;


import User.User;

public class BseaDao<T> {
	  public Connection conn = C3p0.getConnection();
	QueryRunner query =new QueryRunner();
	Class subclass=null;

	BseaDao() {
		Class clazz = this.getClass();
		ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] typeList = type.getActualTypeArguments();

		
	   this.subclass= (Class) typeList[0];
	  
	}
	
	
	
	
	public void batch(String sql ,Object [][] params){
		try {
			query.batch(conn,sql, params);
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
	}	
	
	
	public int Update(String sql ,Object... params){
		int i=0;
		try {
			i = query.update(conn, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return i;
		
	}
	
	public T Query_Bean(String sql, Object... params){  //根据id 获取对象
		
		T sub=null;
		try {
			sub =query.query(conn, sql,new BeanHandler<T>(subclass), params);
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
		return sub;
		
	}
	
	
	public List<T> QueryList(String sql ,Object...params){
		List<T> sub =null;
		try {
			sub=query.query(conn,sql,new BeanListHandler<T>(subclass),params);
		} catch (SQLException e){
		
			throw new RuntimeException(e);
		}finally{
			
		}
		return sub;
		
		
	}
	
	
	public Object getSingleValue(String sql, Object... params){
		Object query2=null;
		try {
			query2  = query.query(conn,sql, new ScalarHandler(),params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return query2;
	}
	
	
	public static void main(String [] args){
		UserDao dao = new UserDao();
		System.out.println(dao.subclass);
		User query = dao.query("国际米兰");
		System.out.println(query);
	}
	

}
