<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Who-Ah-You</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

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


<div class="RegInfoContainer">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">One more step. We just need more of your information.</h1>
    <form method = post action = newAccount>
    <div class="input-container">
        <input type="email" name = "email"id="label" required="required"/> 
        <label for="label">Email</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" name = "pwd" id="label" required="required"/> 
        <label for="label">Password</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" name = "confirmPwd" id="label" required="required"/> 
        <label for="label">Confirm password</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" name = "firstName"id="label" required="required"/> 
        <label for="label">First Name</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" name = "lastName" id="label" required="required"/>
        <label for="label">Last Name</label>
        <div class="bar"></div>
      </div>
	 
	  <div class="input-container">
			<input type="text" name = "street" id="label" required="required"/>
			<label for="label">Street</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
			<input type="text" name = "city" id="label" required="required"/>
			<label for="label">City</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
			<input type="text" name = "state" id="label" required="required"/>
			<label for="label">State</label>
			<div class="bar"></div>
        <div class="bar"></div>
				
        <div class="bar"></div>
      </div>  
	  <div class="input-container">
			<input type="text" name = "zip" id="label" required="required"/>
			<label for="label">Zip code</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
      <div class="input-container">
			<input type="text" name = "phone" id="label" required="required"/>
			<label for="label">Phone</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
			<input type="text" name="SSN" id="label" required="required"/>
			<label for="label">SSN (XXX-XX-XXXX)</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
			<input type="text" name="cardNum" id="label" required="required"/>
			<label for="label">Card #</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
		  <h2 id="PPP_description">Choose your profile placememt priority, users with higher placement prority will be given higher displayment rate on other users</h2>
      </div>
	  <div class="input-container" style="font-size:20px;">
		  <h2>Profile Placement Priority</h2>
		<select id="ppp" >
			<option value="user_user">User-User (free)</option>
			<option value="Good-User">Good-User ($50/yr)</option>
			<option value="Super-User">Super-User ($100/yr)</option>
		</select>
		<div class="bar"></div>
		</div>
     
	  
	  
	  
	  
	  <div class="button-container">
        	<button type= "submit"><span>finish</span></button>
      </div>     
    </form>
  </div>

</div>



  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


	

</body>

</html>