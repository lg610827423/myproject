package product.lg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.lg.factory.DAOFactory;
import product.lg.vo.Product;

public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

		this.doPost(request, response);			//调用doPost方法
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
		request.setCharacterEncoding("utf-8");	
		Product product=new Product();
		boolean flag=false;
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float price=Float.parseFloat(request.getParameter("price"));
		int count=Integer.parseInt(request.getParameter("count"));
		String factory=request.getParameter("factory");
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setCount(count);
		product.setFactory(factory);
		    try {
				
					flag=DAOFactory.getIProductDAOInstance().doModify(product);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("flag", flag);
				response.sendRedirect("SearchServlet");

	}

}
