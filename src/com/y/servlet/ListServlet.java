package com.y.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y.entity.Page;
import com.y.service.ListService;

/**
 * 列表页面初始化控制
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		request.setCharacterEncoding("utf-8");
		// 接受页面的值
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		String currentPage = request.getParameter("currentPage");
		// 创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if (currentPage == null || !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		// 给页面设值
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		request.setAttribute("page", page);
		ListService service = new ListService();
		request.setAttribute("messageList", service.queryMessageListByPage(command, description, page));

		// 跳转到显示页面
		request.getRequestDispatcher("/WEB-INF/jsps/back/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
