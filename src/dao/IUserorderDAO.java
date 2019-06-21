package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Userorder;

/**
 * 数据库操作（增、删、查、改）的接口类
 * @author Xiaoyao
 *
 */
public interface IUserorderDAO {
	
	/**
	 * 查询所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<Userorder> queryAllResult() throws SQLException;
	
	/**
	 * 插入数据
	 * @param userorder
	 * @return
	 * @throws SQLException
	 */
	public int insert(Userorder userorder) throws SQLException;
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int delete(int id) throws SQLException;
	
	/**
	 * 根据id更新数据
	 * @param userorder
	 * @return
	 * @throws SQLException
	 */
	public int update(Userorder userorder) throws SQLException;
	
	/**
	 * 根据phone查找数据
	 * @param phone
	 * @return
	 * @throws SQLExcpetion
	 */
	public List<Userorder> queryByPhone(String phone)  throws SQLException;
	
	/**
	 * 根据Id查找数据
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Userorder queryById(int id)  throws SQLException;
}