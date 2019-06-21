package service;

import java.util.List;

import entity.Userorder;

public interface IUserorderService {

	/**
	 * 获取表格所有数据
	 * @return
	 * @throws Exception
	 */
	public List<Userorder> getAllDatas() throws Exception;
	
	/**
	 * 添加数据
	 * 
	 * @param phone
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int addOrder(Userorder uo) throws Exception;

	/**
	 * 根据id删除数据
	 * 
	 * @param id
	 * @return 返回值为影响记录数
	 * @throws Exception
	 */
	public int deleteById(int id) throws Exception;

	/**
	 * 根据id更新数据
	 * @return
	 */
	public int updateOrder(Userorder newUserorder) throws Exception;

	/**
	 * 根据phone手机号查找数据
	 * 
	 * @param phone 要查找的手机号
	 * @return 
	 * @throws Exception
	 */
	public List<Userorder> searchByPhone(String phone) throws Exception;
	
	/**
	 * 根据Id订单号查找数据
	 * 
	 * @param id 要查找的订单号
	 * @return 
	 * @throws Exception
	 */
	public Userorder searchById(int id) throws Exception;
}