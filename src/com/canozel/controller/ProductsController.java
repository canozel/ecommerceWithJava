package com.canozel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.canozel.dao.ProductDAO;
import com.canozel.dao.impl.ProductDAOImpl;
import com.canozel.model.Product;

@WebServlet("/products")
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PRODUCTS = "/WEB-INF/products/index.jsp";
	private static String SHOW_PRODUCT = "/WEB-INF/products/show.jsp";
	
	//private static String INSERT_OR_EDIT = "";
	private ProductDAO dao; 
	
    public ProductsController() {
        super();
        dao = new ProductDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String userName = null;
		HttpSession session = request.getSession();

		if (request.getParameter("action") != null){
			String action = request.getParameter("action");		
			if (action.equalsIgnoreCase("show")) {
	        	forward = SHOW_PRODUCT;
	        	int id = Integer.parseInt(request.getParameter("id"));
	        	request.setAttribute("product", dao.getProductById(id));
			}
			
		} else if (request.getParameter("category") != null ){
        	forward = PRODUCTS;
    		int category_id = Integer.parseInt( request.getParameter("category"));
    		List<Product> products = dao.getProductsBySubCategoryId(category_id);
    		
    		if (products.size() != 0)
    			request.setAttribute("products", products);
    		else
    			forward = "/WEB-INF/public/404.html";
    	} else {
			int category_id = 1;
			request.setAttribute("products", dao.getProductsBySubCategoryId(category_id));
		}   
				
		
		if (session.getAttribute("user_id") != null) request.setAttribute("userName", userName);

        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
	}
}
