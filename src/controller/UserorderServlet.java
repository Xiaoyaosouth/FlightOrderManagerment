package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import entity.Userorder;
import service.IUserorderService;
import service.impl.UserorderServiceImpl;

@WebServlet("/Userorder.do")
public class UserorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String btnvalue = request.getParameter("order"); // 获取按钮对应的命令
		IUserorderService uos = new UserorderServiceImpl();// 创建自己的service层对象
		Userorder userorder = null;
		List<Userorder> userorderList = null;
		try {
			switch (btnvalue) {
			case "查看订单":
				userorderList = uos.getAllDatas();
				request.setAttribute("userorderList", userorderList);
				request.getRequestDispatcher("queryAll.jsp").forward(request, response);
				break;
			case "添加":
				userorder = new Userorder();
				userorder.setUserId(request.getParameter("insertUserId"));
				userorder.setPhone(request.getParameter("insertPhone"));
				userorder.setName(request.getParameter("insertName"));
				int insertlog = uos.addOrder(userorder);
				request.setAttribute("insertlog", insertlog);
				request.getRequestDispatcher("insertResult.jsp").forward(request, response);
				break;
			case "删除":
				int dId = Integer.parseInt(request.getParameter("deleteId"));
				int deletelog = uos.deleteById(dId);
				request.setAttribute("deletelog", deletelog);
				request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
				break;
			case "修改":
				userorder = new Userorder();
				int uId = Integer.parseInt(request.getParameter("updateId"));
				userorder.setId(uId);
				userorder.setUserId(request.getParameter("updateUserId"));
				userorder.setPhone(request.getParameter("updatePhone"));
				userorder.setName(request.getParameter("updateName"));
				userorder.setStatu(request.getParameter("updateStatu"));
				int updatelog = uos.updateOrder(userorder);
				request.setAttribute("updatelog", updatelog);
				request.getRequestDispatcher("updateResult.jsp").forward(request, response);
				break;
			case "由手机号查找":
				userorderList = uos.searchByPhone(request.getParameter("queryPhone"));
				request.setAttribute("userorderList", userorderList);
				request.getRequestDispatcher("queryAll.jsp").forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}