package com.canozel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canozel.dao.CategoryDAO;
import com.canozel.dao.impl.CategoryDAOImpl;
import com.canozel.model.Category;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ROOT = "/products";
	private CategoryDAO dao; 
	
    public CategoryController() {
        super();
        dao = new CategoryDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if (action.equals("delete")){
    	   dao.deleteCategory(Integer.parseInt(request.getParameter("id")));
       }
       response.sendRedirect(ROOT);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Category category = new Category();
		category.setName((String) request.getParameter("name"));
		dao.addCategory(category);
		response.sendRedirect(ROOT);
//        RequestDispatcher view = request.getRequestDispatcher(ROOT);
//        view.forward(request, response);
	}
}
