package User;

import java.util.Date;

public class Id {
	private Date date = new Date();

	public int getDate(){
		String str=""+date.getTime();
		String str2=str.substring(4, str.length()-1);
		return Integer.parseInt(str2);
	}

	public static void main(String[] args) {
		Id id = new Id();
		System.out.println(id.getDate());
		

	}

}
