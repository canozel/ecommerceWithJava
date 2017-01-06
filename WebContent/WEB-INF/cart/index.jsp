<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siparişler</title>
<!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheets/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheets/style.css"  media="screen,projection"/>
    <script type="text/javascript">
    $(".check").on("click", function(){
    	$.ajax({
	        url: "/loginWithValidationJquery/register",
	        type: "post",
	        data: {check: true} ,
	        success: function (data, status) {
	        	console.log(data)
	        	if (data == "true"){
	        		$("input[name=email]").after('<label id="err" style="color:#ff5b5b">Başarılı. </label>');
	        	} else {
	        		$("input[name=email]").after('<label id="success" style="color:#78e878">Bu email kullanılabilir.</label>');
	        	}
	        },
	        error: function(jqXHR, textStatus, errorThrown) {
	           console.log(textStatus, errorThrown);
	        }
    	});
    };
    </script>
</head>

<body>
	<div class="row">
		<%@ include file="/WEB-INF/layout/nav.jsp"%>
		
		<div class="col m10 page-content">
          <div class="row">
            <div class="col s12 m3">
               <select>
                <option class="black-text" value="" disabled selected>Sıralama Ölçütü</option>
                <option value="1">Fiyatı artan</option>
                <option value="2">Fiyatı azalan</option>
                <option value="3">En çok satılan</option>
              </select>
            </div>
            <div class="col s12 m2">
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
          
          <% if (request.getAttribute("orders") != null || request.getAttribute("orders") != "") { %>
          <c:forEach items="${orders}" var="order">
          <div class="row">
          	 <div class="card-panel hoverable">
	           	  <img width="150px" src="${order.image}">
	              <span>${order.name}</span>
	              <a href="/cart?action=delete&id=${order.id}" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a>
	            </div>
	        </div>	    
	      </c:forEach>
	      <div class='row'>
            <a href = "/cart?action=check" type='submit' name='check' id="check"  class='col s12 btn btn-large waves-effect indigo'>Alışverişi onayla</a>
          </div>
	      <% } else { %>
			<p>Sepetiniz henüz boş durumda</p>
	      <% } %>
	   </div>
	</div>
	
	       <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/materialize.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/javascript.js"></script>
</body>
</html>