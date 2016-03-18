package dispose;

import User.User;
import jdbc.UserDao;

public class OperateUser {
	User user = null;
	private UserDao dao = new UserDao();
	

	public OperateUser() {
		super();

	}

	public OperateUser(String name, String password) {  //µ«»Î’À∫≈

		User query = dao.query(name);

		if (query != null && query.getPassword().equals(password)) {

			this.user = query;

		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}



	public boolean update(String name, String password, String nickname) {  //–ﬁ∏ƒ’À∫≈
		boolean bool = false;
		int add = 0;
		if (user != null) {
			if (password != null) {
				user.setPassword(password);

			} 
			
			if (nickname != null) {
				user.setNickname(nickname);
			}
			if (name != null && dao.query(name) == null) {
				user.setName(name);
			} 
			add = dao.add(user);

		}
		if (add != 0) {
			bool = true;
		}
		return bool;
	}



	public static void main(String[] args) {

		

		
	}
}
