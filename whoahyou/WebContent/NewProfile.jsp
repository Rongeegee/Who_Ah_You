<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<title>Who-Ah-You</title>
  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.`min.css">
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/style.css">

<title>New Profile</title>

</head>
<body>
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Who-Ah-You</h1><h2>where love starts with <span style="color: #F163FA">"Who-Ah-You"</span></h2>
  <br>
  <h2>sign up now to meet the love of your life</h2>
</div>
	
<a style="color:white; fonts-size:30px;"><button  class="pink_button_block" style="margin-left:80%;">&nbsp setting</button></a>

<div class="big_container">
	<div class="card"></div>
  <div class="card">
    <h1 class="title">New Profile</h1>
    <div style="width:30%;margin-left:5%;">
	<h4 style="font-size:20px">upload a profile image(optional):</h4><br>
		<img src="images/defaultProfile.jpg" style="height:150px;width:120px;" id = "profilePic">
		<br><br>
		<input type="file" name="pic" accept="image/*" id="imgPath">
		<input type="submit" onclick="uploadImg()" value="submit image">
		<br><br><br>
	</div>
      <div class="input-container">
        <input type="text" id="label" required="required"/>
        <label for="label">Profile name</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
		<h6 style="font-size:20px;">age:</h6>
		<br>
		<select class="age"></select>
		<br><br>
        <div class="bar"></div>
      </div>
	 
	  <div class="input-container">
			<input type="text" id="label" required="required"/>
			<label for="label">city</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
			<input type="text" id="label" required="required"/>
			<label for="label">state</label>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
		<h6 style="font-size:20px;">gender:</h6>
		<br>
		  <select>
				<option value="male">male</option>
				<option value="female">female</option>
		  </select>
		  <br><br>
        <div class="bar"></div>
				
        <div class="bar"></div>
      </div>  
	   <div class="input-container">
			<h6 style="font-size:20px;">Weight:</h6><br>
			<select class="weight"></select>
		  <br><br>
        <div class="bar"></div>
      </div>
	  <div class="input-container">		
		 <h6 style="font-size:20px;">height:</h6><br>
		  feet: <select class="feet"></select> inches: <select class="inches"></select>
		  <br><br>  
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
      <div class="input-container">
	   <h6 style="font-size:20px;">  Interested in people within:</h6>
			<br><br>
		  <select class="geoRange"></select> mile(s)
		  <br><br>
		  
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
			<br><br>
		  <h1 style="font-size:20px;"> Preferred age:</h1><br>
		  <select class="DatingAgeFrom"></select> to
		  <select class="DatingAgeFrom"></select>
		  <br><br>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
      <div style="margin-left:4.6%;">
	  <p style="font-size:20px;">Use the input and button below to add a hobby:</p>
		<br>
		<input type="text" id="hobby"><button onclick="addHobbies()">add</button>
		<br><br>
		<div>
		<h5 style="font-size:17px;">Hobbies:</h5>
		
		<ul id="hobby_list" style="font-size:17px;margin-left:55px">
		</ul>
	  </div>
	</div>
       <button class="pink_button_block" style="margin-left:40%;margin-top:4%;"><span>next</span></button>
	  </div>
	  
	</div>
	
	</div>
	</div>
	  
	  
  
  
		


  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


	

</body>

</html>