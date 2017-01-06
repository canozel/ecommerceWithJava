<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.canozel.dao.impl.CategoryDAOImpl" %>
<% request.setAttribute("categories", new CategoryDAOImpl().getCategories()); %>
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
	
<title>Ürün Ekle</title>
</head>
<body>
  <div class="row">
	<%@ include file="/WEB-INF/layout/admin/nav.jsp"%>
		<div class="card-panel hoverable indigo lighten-5">
	    <span class="card-title">Ürün Ekle</span>
		<form action="/admin/products?action=new" method="post" accept-charset="UTF-8">
	      <div class="input-field col s12">
	        <input type="text" id="name" name="name" class="validate"></textarea>
	        <label for="name">Ürün Adı</label>
	      </div>
	      <div class="input-field col s12">
	        <input type="text" id="price" name="price" class="validate"></textarea>
	        <label for="price">Ürün Fiyatı</label>
	      </div>
	      <div class="input-field col s12">
	        <select id="category" name="category">
	        <c:forEach items="${categories}" var="category">
	          <option value="${category.id}">${category.name}</option>
	        </c:forEach>
			</select>
			<label>Kategori</label>
		  </div>
          <div class="input-field col s12">
            <input type="text" id="description" name="description" class="validate"></textarea>
            <label for="description">Ürün Açıklaması</label>
          </div>
          <div class="row">
            <label>Resim</label>
            <div class="file-field input-field">
              <div class="btn">
                <span>Resim</span>
                <input type="file" name="file">
              </div>
              <div class="file-path-wrapper">
              <input class="file-path validate" type="text" name="file" placeholder="Resim Yükle">
            </div>
          </div>
         </div>
	     <div class='row'>
           <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Kaydet</button>
         </div>
       </form>
	  </div>
	  <%@ include file="/WEB-INF/layout/admin/footer.jsp"%>
	</div>	
   
          <!--Import jQuery before materialize.js-->
   <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/jquery-2.1.1.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/materialize.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/javascript.js"></script>
</body>
</html>