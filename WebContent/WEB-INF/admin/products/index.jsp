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
	
<title>Admin Ürün</title>

</head>
<body>
      <div class="row">
		<%@ include file="/WEB-INF/layout/admin/nav.jsp"%>
		          
          <div class="row">
          <a href="/admin/products?action=new" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
          <c:forEach items="${products}" var="product">
            <div class="col s4 m4">
	          <div class="card">
	           	<div class="card-image">
	              <img src="${product.image}">
	            </div>
	            <div class="card-action">
	              <span>${product.name}</span>
	     	 	  <a href="/admin/products?action=delete&id=${product.id}" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a>
	     	 	  <a href="/admin/products?action=edit&id=${product.id}" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">mode_edit</i></a>
	            </div>
	          </div>    
	        </div>
	      </c:forEach>
		  </div>
	      
	      <%@ include file="/WEB-INF/layout/admin/footer.jsp"%>	
	    </div>
	    </div>

          <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/materialize.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/javascript.js"></script>
</body>
</html>