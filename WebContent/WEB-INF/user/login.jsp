<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheets/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheets/style.css"  media="screen,projection"/>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascript/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascript/materialize.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascript/javascript.js"></script>

  <style>
    body {
      display: flex;
      min-height: 100vh;
      flex-direction: column;
      font-family: "Roboto", sans-serif;
      padding: 10px;
    }

    main {
      flex: 1 0 auto;
    }

    body {
      background: #fff;
    }

    .input-field input[type=date]:focus + label,
    .input-field input[type=text]:focus + label,
    .input-field input[type=email]:focus + label,
    .input-field input[type=password]:focus + label {
      color: #e91e63;
    }

    .input-field input[type=date]:focus,
    .input-field input[type=text]:focus,
    .input-field input[type=email]:focus,
    .input-field input[type=password]:focus {
      border-bottom: 2px solid #e91e63;
      box-shadow: none;
    }
  </style>
</head>

<body>
  <div class="section"></div>
  <main>    <center>

      <img class="" width="300px" src="${pageContext.request.contextPath}/assets/images/logo.jpg">
      <div class="section"></div>

      <h5 class="indigo-text">Lütfen hesabınıza giriş yapın</h5>
      <div class="section"></div>

      <div class="container">
        <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

          <form class="col s12" action="/login" method="post">
            <div class='row'>
              <div class='col s12'>
              </div>
            </div>

            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='email' name='email' id='email' />
                <label for='email'>Email</label>
              </div>
            </div>

            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='password' name='password' id='password' />
                <label for='password'>Parola</label>
              </div>
              <label style='float: right;'>
				<a class='pink-text' href='#!'><b>Parolamı unuttum</b></a>
			  </label>
            </div>

            <br />
            <center>
              <div class='row'>
                <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Giriş</button>
              </div>
            </center>
          </form>
        </div>
      </div>
      <a href="/register">Hesap oluştur</a>
    </center>

    <div class="section"></div>
    <div class="section"></div>
  </main>
</body>

</html>