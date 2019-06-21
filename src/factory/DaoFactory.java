package factory;

import dao.IUserorderDAO;
import dao.impl.UserorderDAOImpl;

/**
 * DAO工厂类
 * 说明：提供一个返回值为DAO接口类型的静态方法，获得DAO实现的实例
 */
public class DaoFactory {

	/**
	 * 获得DAO对象
	 * @return
	 */
    public static IUserorderDAO getUserorderDAOInstance()
    {
    	IUserorderDAO userorderDao = new UserorderDAOImpl();
        return userorderDao; // 返回DAO操作对象
    }

}