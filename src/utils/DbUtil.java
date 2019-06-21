package utils;

import java.io.*;
import java.sql.*;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接工具类
 * 说明：使用c3p0连接池。使用本类前
 * （1）将mysql-connector-java-5.1.16-bin.jar放到\WebContent\WEB-INF\lib
 * （2）将c3p0-0.9.5.2.jar放到\WebContent\WEB-INF\lib
 * （3）将mchange-commons-java-0.2.11.jar放到\WebContent\WEB-INF\lib
 */
public class DbUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	private static DataSource dataSource = null;

	static {
		// 使用C3P0的命名配置来创建数据源
		dataSource = new ComboPooledDataSource("mysql");
		System.out.println("c3p0数据库连接池创建完成！");
	}

	/**
	 * 获取数据库连接
	 * @return Connection对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null && conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

} // class end