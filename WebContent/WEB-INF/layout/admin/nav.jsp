<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
		<div class="col m2 page-content">
		  <ul id="slide-out" class="side-nav fixed z-depth-2">
		    <li class="center no-padding">
		      <div class="indigo darken-2 white-text" style="height: 180px;">
		        <div class="row">
		          <img  width="100" height="100" src="${pageContext.request.contextPath}/assets/images/logo.jpg" class="circle responsive-img" />
		
		          <p>
		            Can Hediye
		          </p>
		        </div>
		      </div>
		    </li>
		
		    <li id="dash_dashboard"><a class="waves-effect" href="/admin"><b>Admin Paneli</b></a></li>
		
		    <ul class="collapsible" data-collapsible="accordion">
		      <li id="dash_users">
		        <div id="dash_users_header" class="collapsible-header waves-effect"><b>Müşteriler</b></div>
		        <div id="dash_users_body" class="collapsible-body">
		          <ul>
		            <li id="users_seller">
		              <a class="waves-effect" style="text-decoration: none;" href="#!">Satıcılar</a>
		            </li>
		
		            <li id="users_customer">
		              <a class="waves-effect" style="text-decoration: none;" href="/admin/users?action=list">Müşteriler</a>
		            </li>
		          </ul>
		        </div>
		      </li>
		
		      <li id="dash_products">
		        <div id="dash_products_header" class="collapsible-header waves-effect"><b>Ürünler</b></div>
		        <div id="dash_products_body" class="collapsible-body">
		          <ul>
		            <li id="products_product">
		              <a class="waves-effect" style="text-decoration: none;" href="/admin/products?action=list">Ürünler</a>
		              <a class="waves-effect" style="text-decoration: none;" href="/admin/carts?action=list">Siparişler</a>
		            </li>
		          </ul>
		        </div>
		      </li>
		
		      <li id="dash_categories">
		        <div id="dash_categories_header" class="collapsible-header waves-effect"><b>Kategorler</b></div>
		        <div id="dash_categories_body" class="collapsible-body">
		          <ul>
		            <li id="categories_category">
		              <a class="waves-effect" style="text-decoration: none;" href="/admin/categories?action=list">Kategori</a>
		            </li>
		
		            <li id="categories_sub_category">
		              <a class="waves-effect" style="text-decoration: none;" href="#!">Alt Kategori</a>
		            </li>
		          </ul>
		        </div>
		      </li>
		
		    
		    </ul>
		  </ul>
		</div>
		<div class="col m10 page-content">
		  <header>
		    <ul class="dropdown-content" id="user_dropdown">
		      <li><a class="indigo-text" href="#!">Profil</a></li>
		      <li><a class="indigo-text" href="/logout">Çıkış</a></li>
		    </ul>
		
		    <nav class="indigo" role="navigation">
		      <div class="nav-wrapper">
		        <a data-activates="slide-out" class="button-collapse show-on-" href="#!"><img style="margin-top: 17px; margin-left: 5px;" src="https://res.cloudinary.com/dacg0wegv/image/upload/t_media_lib_thumb/v1463989873/smaller-main-logo_3_bm40iv.gif" /></a>
		
		        <ul class="right hide-on-med-and-down">
		          <li>
		            <a class='right dropdown-button' href='' data-activates='user_dropdown'><i class=' material-icons'>account_circle</i></a>
		          </li>
		        </ul>
		
		        <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
		      </div>
		    </nav>
		
		    <nav>
		      <div class="nav-wrapper indigo darken-2">
		        <a style="margin-left: 20px;" class="breadcrumb" href="#!">Admin</a>
		        <a class="breadcrumb" href="#!">Ürün</a>
		
		        <div style="margin-right: 20px;" id="timestamp" class="right"></div>
		      </div>
		    </nav>
		  </header>