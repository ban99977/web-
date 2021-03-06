package servlets;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.DealDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Deal;
import entity.User;

public class DealServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String opr=request.getParameter("opr");
		if(opr.equals("list")){
			DealDaoImpl cdi=new DealDaoImpl();
			List<Deal> listdeal=cdi.getAll();
			request.getSession().setAttribute("listdeal", listdeal);
			response.sendRedirect("controldeal.jsp");	
		}
		else if(opr.equals("fuzzy")){
			DealDaoImpl cdi=new DealDaoImpl();
			String gid=request.getParameter("gid");
			List<Deal> listdeal=cdi.getDealByName(gid);
			request.getSession().setAttribute("listuser", listdeal);
			System.out.println("marksearch");
			response.sendRedirect("controldeal.jsp");
				
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
