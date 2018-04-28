<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Who-Ah-You</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.`min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Who-Ah-You</h1><h2>where love starts with <span style="color: #F163FA">"Who-Ah-You"</span></h2>
  <br>
  <h2>sign up now to meet the love of your life</h2>
</div>
<form method ="post" action="LogInServlet">
<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Login</h1>
    <form>
      <div class="input-container">
        <input type="text" id="label" name ="email" required="required"/>
        <label for="label">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="label" name = "pwd" required="required"/>
        <label for="label">Password</label>
        <div class="bar"></div>
      </div>
      
      <div class="button-container">
        <button type="submit"><span>Go</span></button>
      </div>
      </form>
      <div class="footer"><a href="#">Forgot your password?</a></div>
	  <div ><a href="employeeLogIn.jsp" class="employLogIn">I am an employee!</a></div>
    </form>
  </div>
  
  
  <div class="card alt">
    <div class="toggle"></div>
    <h1 class="title">Register
      <div class="close"></div>
    </h1>
    <form>
      <div class="input-container">
        <input type="text" id="label" required="required"/>
        <label for="label">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="label" required="required"/>
        <label for="label">Password</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="label" required="required"/>
        <label for="label">Repeat Password</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button><a href="register.jsp" class="next_text">Next</a></button>
      </div>
    </form>
  </div>
</div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


	

</body>

</html>
