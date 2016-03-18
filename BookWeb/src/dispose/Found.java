package dispose;

import java.util.Date;

import User.Id;
import User.User;
import jdbc.UserDao;

public class Found {   //×¢²á
	public User user;
	public static UserDao dao = new UserDao();


	public Found(String name, String password,String nickname){
		this.user=new User(new Id().getDate(),name, password, nickname);

	}

	public boolean Found() {
		boolean bool = false;
		String name = user.getName();
		User query = dao.query(name);
		if (query == null) {
			dao.add(user);
			bool = true;
		}
		
		return bool;

	}
	
	
	public static void main(String[] args){
//		 	Found found = new Found("ËØÑÅ","1234","öµÑÀ");
//		 	boolean bool = found.Found();
//		 	System.out.println(bool);
//		 Date date = new Date();
		 
	}
}
