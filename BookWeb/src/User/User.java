package User;

public class User {
	private int id;
	private String name;
	private String password;
	private String nickname;

	public User() {
		super();
	}

	public User(int id, String name, String password, String nickname) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name+", nickname=" + nickname + "]";
	}

	public static void main(String[] args) {
		
		
	
	}

}
