package dao.impl;

import java.sql.*;
import java.util.*;

import dao.IUserorderDAO;
import entity.Userorder;
import utils.DbUtil;

public class UserorderDAOImpl implements IUserorderDAO {
	
	private Connection conn = null;
	
	public UserorderDAOImpl() {
		conn = DbUtil.getConnection(); // 通过连接池建立连接
	}
	
	@Override
	public List<Userorder> queryAllResult() throws SQLException {
		List<Userorder> userorderList = null;
		Statement stmt = null;
		ResultSet rs = null;
		String querysql = "SELECT * FROM userorder";
		try {
			stmt = conn.createStatement(); // 建立连接并向数据库发送SQL语句
			rs = stmt.executeQuery(querysql); // 进行查询
			userorderList = new ArrayList<Userorder>(); // 实例化实体类列表
			while (rs.next()) {
				Userorder userorder = new Userorder();
				userorder.setId(rs.getInt("Id"));
				userorder.setPhone(rs.getString("phone"));
				userorder.setName(rs.getString("name"));
				userorder.setUserId(rs.getString("userId"));
				userorder.setStatu(rs.getString("statu"));
				userorder.setStartTime(rs.getTimestamp("startTime"));
				userorder.setUpdateTime(rs.getTimestamp("updateTime"));
				userorder.setTotalPrice(rs.getString("totalPrice"));
				userorderList.add(userorder);
			}
			System.out.println("查询成功！共查询到"+userorderList.size()+"条数据");
			rs.close();
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		} finally {
			DbUtil.close(conn);
		}
		return userorderList;
	}

	@Override
	public int insert(Userorder userorder) throws SQLException {
		PreparedStatement pstmt = null;
		String insertsql = "INSERT INTO userorder "
				+ "(userId,phone,name,startTime,updateTime) "
				+ "VALUES(?,?,?,?,?)";
		int updatelog = 0; // 保存数据更新影响记录数
		try {
			pstmt = conn.prepareStatement(insertsql);
			pstmt.setString(1, userorder.getUserId());
			pstmt.setString(2, userorder.getPhone());
			pstmt.setString(3, userorder.getName());
			Timestamp ts = new Timestamp(new java.util.Date().getTime());
			pstmt.setTimestamp(4, ts);
			pstmt.setTimestamp(5, ts);
			updatelog = pstmt.executeUpdate();
			System.out.println("插入数据成功！影响记录数：" + updatelog);
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException sqle) {
			System.out.println("插入数据失败！");
			throw new RuntimeException(sqle);
		} finally {
			DbUtil.close(conn);
		}
		return updatelog;
	}

	@Override
	public int delete(int id) throws SQLException {
		PreparedStatement pstmt = null;
		String deletesql = "DELETE FROM userorder WHERE id=?";
		int updatelog = 0; // 保存数据更新影响记录数
		try {
			pstmt = conn.prepareStatement(deletesql);
			pstmt.setInt(1, id);
			updatelog = pstmt.executeUpdate();
			System.out.println("删除数据成功！影响记录数：" + updatelog);
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException sqle) {
			System.out.println("删除数据失败！");
			throw new RuntimeException(sqle);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return updatelog;
	}

	@Override
	public int update(Userorder userorder) throws SQLException {
        PreparedStatement pstmt = null;
        String updatesql = "UPDATE userorder SET "
        		+ "userId=?,phone=?,name=?,statu=?,updateTime=? "
        		+ "WHERE id=?";
        int updatelog = 0; // 保存数据更新影响记录数
        try
        {
            pstmt = conn.prepareStatement(updatesql);
            pstmt.setString(1, userorder.getUserId());
            pstmt.setString(2, userorder.getPhone());
            pstmt.setString(3, userorder.getName());
            pstmt.setString(4, userorder.getStatu());
            Timestamp ts = new Timestamp(new java.util.Date().getTime());
            pstmt.setTimestamp(5, ts); // 修改订单后重设更新时间
            pstmt.setInt(6, userorder.getId()); // 要更新的订单号
            updatelog = pstmt.executeUpdate();
            System.out.println("更新数据成功！影响记录数："+updatelog);
            if (pstmt != null)
            {
                pstmt.close();
            }
        } catch (SQLException sqle)
        {
            System.out.println("更新数据失败！");
            throw new RuntimeException(sqle);
        } finally
        {
        	DbUtil.close(conn);
        }
        return updatelog;
	}

	@Override
	public List<Userorder> queryByPhone(String phone) throws SQLException {
		List<Userorder> userorderList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String querysql = "SELECT * FROM userorder WHERE phone=?";
		try {
			pstmt = conn.prepareStatement(querysql); // 建立连接并向数据库发送SQL语句
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery(); // 进行查询
			userorderList = new ArrayList<Userorder>(); // 实例化实体类列表
			while (rs.next()) {
				Userorder userorder = new Userorder();
				userorder.setId(rs.getInt("Id"));
				userorder.setPhone(rs.getString("phone"));
				userorder.setName(rs.getString("name"));
				userorder.setUserId(rs.getString("userId"));
				userorder.setStatu(rs.getString("statu"));
				userorder.setStartTime(rs.getTimestamp("startTime"));
				userorder.setUpdateTime(rs.getTimestamp("updateTime"));
				userorder.setTotalPrice(rs.getString("totalPrice"));
				userorderList.add(userorder);
			}
			System.out.println("查询成功！共查询到"+userorderList.size()+"条数据");
			rs.close();
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		} finally {
			DbUtil.close(conn);
		}
		return userorderList;
	}

	@Override
	public Userorder queryById(int id) throws SQLException {
		Userorder userorder = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String querysql = "SELECT * FROM userorder WHERE Id=?";
		try {
			pstmt = conn.prepareStatement(querysql); // 建立连接并向数据库发送SQL语句
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery(); // 进行查询
			while (rs.next()) {
				userorder = new Userorder(); // 保存查询的数据项
				userorder.setId(rs.getInt("Id"));
				userorder.setPhone(rs.getString("phone"));
				userorder.setName(rs.getString("name"));
				userorder.setUserId(rs.getString("userId"));
				userorder.setStatu(rs.getString("statu"));
				userorder.setStartTime(rs.getTimestamp("startTime"));
				userorder.setUpdateTime(rs.getTimestamp("updateTime"));
				userorder.setTotalPrice(rs.getString("totalPrice"));
			}
			rs.close();
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		} finally {
			DbUtil.close(conn);
		}
		return userorder;
	}

}