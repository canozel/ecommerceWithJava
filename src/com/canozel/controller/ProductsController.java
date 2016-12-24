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
	private static String NEW_PRODUCT = "/WEB-INF/products/new.jsp";
	
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
//		try {
		if (request.getParameter("action") != null){
			String action = request.getParameter("action");		
			if (action.equalsIgnoreCase("show")) {
	        	forward = SHOW_PRODUCT;
	        	int id = Integer.parseInt(request.getParameter("id"));
	        	request.setAttribute("product", dao.getProductById(id));
			} else if (action.equalsIgnoreCase("new")){
				forward = NEW_PRODUCT;
			} else if (action.equals("delete") && (session.getAttribute("user_id") != null)){
				forward = PRODUCTS;
				int id = Integer.parseInt(request.getParameter("id"));
				dao.deleteProduct(id);
			}
			
		} else {
//		} catch (Exception e) {
        	forward = PRODUCTS;
//        	try {
        	if (request.getParameter("category") != null ){
        		int category_id = Integer.parseInt( request.getParameter("category"));
        		List<Product> products = dao.getProductsBySubCategoryId(category_id);
        		if (products.size() != 0)
        			request.setAttribute("products", products);
        		else
        			forward = "/WEB-INF/public/404.html";
        	} else {
//			} catch (Exception e2) {
				int category_id = 1;
				request.setAttribute("products", dao.getProductsBySubCategoryId(category_id));
			}   
		}		
		
		if (session.getAttribute("user_id") != null) request.setAttribute("userName", userName);
        /*if (action.equalsIgnoreCase("delete") ) {
            forward = LIST_PRODUCTS;
            int id = Integer.parseInt( request.getParameter("id") );
            dao.deleteProduct(id);
            request.setAttribute("students", dao.getProductsBySubCategoryId(1));
            
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int studentId = Integer.parseInt( request.getParameter("studentId") );
            Student student = dao.getStudentById(studentId);
            request.setAttribute("student", student);
            
        } else if ( action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
            
        } */
		
//		response.sendRedirect(forward);
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//	response.setContentType("text/html; charset=utf-8");
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(request.getParameter("price"));
		product.setDescription(request.getParameter("description"));
		product.setCategory_id(Integer.parseInt(request.getParameter("category")));
		product.setImage("/assets/images/" + request.getParameter("file"));
		dao.addProduct(product);
		
		//response.sendRedirect(PRODUCTS);
		RequestDispatcher view = request.getRequestDispatcher( PRODUCTS );
        view.forward(request, response);
	}

}
