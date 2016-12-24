<%@page import="com.canozel.dao.impl.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.canozel.dao.impl.CategoryDAOImpl" %>
<% request.setAttribute("categories", new CategoryDAOImpl().getCategories()); %>
  <div class="col m2 fixed"> 	
    <ul id="slide-out" class="side-nav fixed">
      <img class="" width="100%" src="${pageContext.request.contextPath}/assets/images/logo.jpg">
      <hr>
      <li>
      	<% if (session.getAttribute("userName") != null) {%>
      		${userName} <a href= "/logout">Çıkış Yap</a>
      	<% } else { %>
      		<a href= "/login">Giriş Yap</a>
      	<% } %> 
      	<span><a href= "/cart"><i href="/cart" class="material-icons">shopping_cart</i></a></span>
      </li>
      <hr>
       <c:forEach items="${categories}" var="category">
         <li>
           <a href="/products?category=${category.id}">${category.name}</a>
           <% if (session.getAttribute("user_id") != null && new UserDAOImpl().isAdmin((int )session.getAttribute("user_id"))) {%>
           	 <a href="/cart?action=new&id=${category.id}" rel="nofollow" data-method="delete"><i class="material-icons right">delete</i></a>
           	<% } %>
         </li>
       </c:forEach>
	    <% if (session.getAttribute("user_id") != null && new UserDAOImpl().isAdmin((int )session.getAttribute("user_id"))) {%>
	    <hr>
	    <div class="card-panel hoverable indigo lighten-5">
	      <span class="card-title">Kategori Ekle</span>
	      <form action="/category" method="post">
	      	<div class="input-field col s12">
	          <input type="text" id="name" name="name" class="validate"></textarea>
	          <label for="name">Kategori İsmi</label>
	        </div>
	        <div class='row'>
                <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Kaydet</button>
             </div>
	      </form>
	      </div>
	    <% } %>
    </ul>      
  </div>
