package utils;

import java.io.*;
import java.sql.*;

/**
 * 数据库连接工具类
 * 说明：没有使用连接池
 */
public class DbUtil_bak implements Serializable {
	private static final long serialVersionUID = 1L;

	private String jdbcUrl;
	private String username;
	private String password;
	private Connection dbConnection = null;

	public void setPassword(String password) {
		this.password = password;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public DbUtil_bak() {
		try {
			this.jdbcUrl = "jdbc:mysql://localhost:3306/javaweb";
			this.username = "root";
			this.password = "123456";
			// 将mysql-connector-java-?-bin.jar放到\WebContent\WEB-INF\lib
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}

	public Connection getConnection() {
		if (dbConnection == null) {
			try {
				dbConnection = DriverManager.getConnection(jdbcUrl, username, password);
			} catch (SQLException sqle) {
				throw new RuntimeException(sqle);
			}
		}
		return dbConnection;
	}

	public boolean close() {
		if (dbConnection != null) {
			try {
				dbConnection.close();
				return true;
			} catch (SQLException sqle) {
				throw new RuntimeException(sqle);
			}
		}
		return false;
	}

	// 书上的
	public boolean isConnectedOK() {
		boolean ok = false;
		Connection conn = null;
		SQLException ex = null;
		try {
			conn = DriverManager.getConnection(jdbcUrl, username, password);
			if (!conn.isClosed()) {
				ok = true;
			}
		} catch (SQLException e) {
			ex = e;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					if (ex == null) {
						ex = e;
					}
				}
			}
			if (ex != null) {
				throw new RuntimeException(ex);
			}
		}
		return ok;
	} // method end

}
