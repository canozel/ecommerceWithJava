<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheets/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheets/style.css"  media="screen,projection"/>

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico"> 

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
<title>CanHediye</title>

</head>
<body>
      <div class="row">
		<%@ include file="/WEB-INF/layout/nav.jsp"%>

        <div class="col m10 page-content">
          <div class="row">
            <div class="col s12 m3">
              <select>
                <option class="black-text" value="" disabled selected>Choose your option</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
              </select>
            </div>
            <div class="col s12 m2">
              bla bla
            </div>
            <div class="col s12 m7">
              <nav>
                <div class="nav-wrapper orange accent-2">
                  <form>
                    <div class="input-field">
                      <input id="search" type="search" required>
                      <label for="search"><i class="material-icons">search</i></label>
                      <i class="material-icons">close</i>
                    </div>
                  </form>
                </div>
              </nav>
            </div>
          </div>
          
          <div class="row">
          <c:forEach items="${products}" var="product">
            <div class="col s4 m4">
	          <div class="card">
	           	<div class="card-image">
	              <img src="${product.image}">
	            </div>
	            <div class="card-action">
	              <span>${product.name}</span>
	              <% if (session.getAttribute("user_id") != null && new UserDAOImpl().isAdmin((int )session.getAttribute("user_id"))) {%>
	     	 		<a href="/products?action=delete&id=${product.id}" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a>
	      		  <% } %>
	              <a href="/cart?action=new&id=${product.id}" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons right">add</i></a>
	            </div>
	          </div>    
	        </div>
	      </c:forEach>
		  </div>
	      <% if (session.getAttribute("user_id") != null && new UserDAOImpl().isAdmin((int )session.getAttribute("user_id"))) {%>
	     	 <a href="/products?action=new" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
	      <% } %>
	      </div>
      </div>  
      
          <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/materialize.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/javascript.js"></script>
</body>
</html>