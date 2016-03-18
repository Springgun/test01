package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0 {

	static ComboPooledDataSource cpds = new ComboPooledDataSource();

	static ThreadLocal<Connection> connlist = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		Connection conn = connlist.get();
		if (conn == null) {
			try {
				conn = cpds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connlist.set(conn);
			
		}
		System.out.println(Thread.currentThread());
		return conn;
	}

	public static void close() {
		Connection conn =connlist.get();
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		connlist.remove();
	}

}
