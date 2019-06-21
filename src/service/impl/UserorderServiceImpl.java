package service.impl;

import java.util.List;
import dao.IUserorderDAO;
import dao.impl.UserorderDAOImpl;
import entity.Userorder;
import factory.DaoFactory;
import service.IUserorderService;

/**
 * 业务逻辑接口的具体实现类
 * 说明：该类的方法主要是调用DAO进行数据库访问，并将数据返回给Servlet
 */
public class UserorderServiceImpl implements IUserorderService {

	 private IUserorderDAO userorderDao = DaoFactory.getUserorderDAOInstance();
	
	@Override
	public List<Userorder> getAllDatas() throws Exception {
		List<Userorder> userorderList = userorderDao.queryAllResult();
		return userorderList;
	}
	
	@Override
	public int addOrder(Userorder uo) throws Exception {
		int updatelog = userorderDao.insert(uo);
		return updatelog;
	}

	@Override
	public int deleteById(int id) throws Exception {
		if (id <= 0) {
			throw new IllegalArgumentException("ID不能小于1。");
		}
		int updatelog = userorderDao.delete(id);
		return updatelog;
	}

	@Override
	public int updateOrder(Userorder uo) throws Exception {
		if (uo.getId() <= 0) {
			throw new IllegalArgumentException("ID不能小于1。");
		}
		int updatelog = userorderDao.update(uo);
		return updatelog;
	}

	@Override
	public List<Userorder> searchByPhone(String phone) throws Exception {
		List<Userorder> userorderList = userorderDao.queryByPhone(phone);
		return userorderList;
	}

	@Override
	public Userorder searchById(int id) throws Exception {
		Userorder userorder = null;
		userorder = userorderDao.queryById(id);
		return userorder;
	}

}