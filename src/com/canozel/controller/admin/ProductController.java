package com.canozel.controller.admin;

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

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/admin/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String NEW_PRODUCT = "/WEB-INF/admin/products/new.jsp";
	private static String PRODUCTS = "/WEB-INF/admin/products/index.jsp";
	private static String EDIT_PRODUCT = "/WEB-INF/admin/products/edit.jsp";
	
	private ProductDAO dao; 
	
    public ProductController() {
        super();
        dao = new ProductDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forward = "";
		
		if (session.getAttribute("user_id") != "" && session.getAttribute("user_id") != null) {
			if (request.getParameter("action") != null) {
				String action = request.getParameter("action");		
			
			    if (action.equalsIgnoreCase("new")){
			    	forward = NEW_PRODUCT;
			    } else if (action.equalsIgnoreCase("edit")) {
			    	forward = EDIT_PRODUCT;
			    	int id = Integer.parseInt(request.getParameter("id"));
			    	Product product = dao.getProductById(id);
			    	request.setAttribute("product", product);
			    } else if (action.equalsIgnoreCase("delete") && (session.getAttribute("user_id") != null)){
					forward = PRODUCTS;
					int id = Integer.parseInt(request.getParameter("id"));
					dao.deleteProduct(id);
			    } else {
			    	forward = PRODUCTS;
			    	List<Product> products = dao.getProducts();
			    	
			    	request.setAttribute("products", products);
			    }
			} else {
		    	forward = PRODUCTS;
		    	List<Product> products = dao.getProducts();
		    	
		    	request.setAttribute("products", products);
		    }
		} else {
			forward = "/WEB-INF/public/404.html";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forward = "";
		
		if (request.getParameter("action") != null && session.getAttribute("user_id") != null) {
			String action = request.getParameter("action");	
		
			if (action.equalsIgnoreCase("new")){
				request.setCharacterEncoding("UTF-8");
				Product product = new Product();
				product.setName(request.getParameter("name"));
				product.setPrice(request.getParameter("price"));
				product.setDescription(request.getParameter("description"));
				product.setCategory_id(Integer.parseInt(request.getParameter("category")));
				product.setImage("/assets/images/" + request.getParameter("file"));
				dao.addProduct(product);
			} else if (action.equalsIgnoreCase("edit")) {
				request.setCharacterEncoding("UTF-8");
				
				Product product = new Product();
				product.setId(Integer.parseInt(request.getParameter("id")));
				product.setName(request.getParameter("name"));
				product.setPrice(request.getParameter("price"));
				product.setDescription(request.getParameter("description"));
				product.setCategory_id(Integer.parseInt(request.getParameter("category")));
				product.setImage("/assets/images/" + request.getParameter("file"));
				dao.updateProduct(product);;
			}
			
			forward = PRODUCTS;
		} else {
			forward = "/WEB-INF/public/404.html";
		}
		
		//response.sendRedirect(PRODUCTS);
		RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
	}

}
