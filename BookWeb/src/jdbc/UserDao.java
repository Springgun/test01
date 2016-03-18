package jdbc;

import User.User;

public class UserDao extends BseaDao<User> {
	
	
	public int  add(User user){ //ÃÌº”
		String sql="insert into test_BookUser(id,name,password,nickname) values(?,?,?,?)";
		int i= this.Update(sql,user.getId(),user.getName(),user.getPassword(),user.getNickname());
		return i;
	}
	
	public User query(String Name){ //≤È—Ø
		String sql ="select id,name,password ,nickname from test_BookUser where name=?";
		User BeanUser= this.Query_Bean(sql,Name);

		return BeanUser;
	}
	
	public int del(User user){
		String sql= "DELETE FROM test_BookUser WHERE id = ? AND name = ? AND password = ? AND nickname = ?";
		int i = this.Update(sql,user.getId(),user.getName(),user.getPassword(),user.getNickname());
		return i;
	}
	
	public int subUpdate(User user){
		String sql =" UPDATE test_BookUser SET name=?,password=?,nickname=? WHERE id=? ";
		int i = this.Update(sql, user.getName(),user.getPassword(),user.getNickname(), user.getId());
		return i;
	}
	
	
	

	
}
