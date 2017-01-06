package com.canozel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.canozel.dao.UserDAO;
import com.canozel.dao.impl.UserDAOImpl;
import com.canozel.model.User;

@WebServlet({ "/login", "/register", "/logout" })
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LOGIN = "/WEB-INF/user/login.jsp";
	private static String REGISTER = "/WEB-INF/user/register.jsp";
	private static String ROOT = "/products";
	
       
	private UserDAO dao;
	
    public SessionController() {
        super();
        dao = new UserDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String uri = request.getRequestURI();
		HttpSession session = request.getSession(false);
		
        if (session.getAttribute("user_id") == null) {
			if (uri.equals("/login")){
				forward = LOGIN;
				
			} else if (uri.equals("/register")){
				forward = REGISTER;
			}
			
	    } else { 
            session.invalidate();
            forward = ROOT;
	    }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		HttpSession session = request.getSession();
        String forward = "";
        String uri = request.getRequestURI();
        int id;
		if (uri.equals("/login")){
	        user.setEmail(request.getParameter("email"));
	        user.setPassword(request.getParameter("password"));
	        id = dao.authentication(user); 
	        if (id != 0) {
	            session.setAttribute("userName", user.getEmail());
	            session.setAttribute("user_id", id);
	            forward = ROOT;
	            
	        } else {
	            PrintWriter out = response.getWriter();
	            out.println("<font color=red>Lütfen doğru girdiğinizden emin olun.</font>\n");
	            forward = LOGIN;
	        }
	        
		} else if (uri.equals("/register")){
			// FIX user email control with ajax. 
			
			/*if (request.getParameter("action") != null){
				String action = request.getParameter("action");		
				if (action.equalsIgnoreCase("check")) {
					String email = request.getParameter("email");
					response.getWriter().print(dao.doesExistUserEmail(email));
				}
			} else {*/
				user.setEmail(request.getParameter("email"));
		        user.setPassword(request.getParameter("password"));
		        
		        id = dao.addUser(user);
		        
	            session.setAttribute("userName", user.getEmail());
	            session.setAttribute("user_id", id);
	            forward = ROOT;
			//}
		}
		//response.sendRedirect(forward);
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
