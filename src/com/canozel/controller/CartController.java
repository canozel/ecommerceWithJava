package com.canozel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.canozel.dao.OrderDAO;
import com.canozel.dao.impl.OrderDAOImpl;
import com.canozel.model.Order;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LOGIN = "/WEB-INF/user/login.jsp";
	private static String ORDERS = "/WEB-INF/cart/index.jsp";
	
	private OrderDAO dao;
    public CartController() {
        super();
        dao = new OrderDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		String user = (String) session.getAttribute("user");
		String forward = "";
//		if (session.getAttribute("user") != null){
//			RequestDispatcher view = request.getRequestDispatcher(LOGIN);
//	        view.forward(request, response);
//		} else {
//			request.setAttribute("orders", dao.getOrdersByUserId(Integer.parseInt(user)));
//		}
		
//		Cookie loginCookie = null;
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("user")) {
//                    loginCookie = cookie;
//                    break;
//                }
//            }
//        }
//        if (loginCookie != null) {
        if (session.getAttribute("user_id") != null) {
    	    if (session.getAttribute("user_id") != null && request.getParameter("action") != null) {
    	    	String action = request.getParameter("action");
    	    	if (action.equals("new")){
    	    		int id = Integer.parseInt(request.getParameter("id"));
    	    		forward = ORDERS;
    	    		Order order = new Order();
    	    		order.setProduct_id(id);
    	    		order.setUser_id((int) session.getAttribute("user_id"));
    	    		order.setIs_checked(false);
    	    		try {
    	    			dao.addOrder(order);
					} catch (Exception e) {

					}
    	        	
    	    	} else if (action.equals("delete")) {
    	    		int id = Integer.parseInt(request.getParameter("id"));
    	    		forward = ORDERS;
    	    		int user_id = (int) session.getAttribute("user_id");
    	    		try {
    	    			dao.deleteOrder(id, user_id);
					} catch (Exception e) {
						// TODO: handle exception
					}
    	    		
    	    	}
    		} else {
            request.setAttribute("orders", dao.getOrdersByUserId((int) session.getAttribute("user_id")));
            forward = ORDERS;
    		}
        } else {
        	forward = LOGIN;
        }
//        response.sendRedirect(forward);
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
