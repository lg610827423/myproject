package product.lg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.lg.factory.DAOFactory;
import product.lg.vo.Product;

public class CreateServlet extends HttpServlet {

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
		this.doPost(request, response);			//调用doPost操作
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
		String path="create.jsp";
		Product product=new Product();
		//接收传递的信息
		product.setId(Integer.parseInt(request.getParameter("id")));
		product.setName(request.getParameter("name"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setCount(Integer.parseInt(request.getParameter("count")));
		product.setFactory(request.getParameter("factory"));
		try{
			if(DAOFactory.getIProductDAOInstance().doCreate(product)){
				request.setAttribute("info", "添加成功");
			}else{
				request.setAttribute("info", "添加失败！！！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
