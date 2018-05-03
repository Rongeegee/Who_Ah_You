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
  

<!-- Pen Title-->
<div class="pen-title">
  <h1>Who-Ah-You</h1><h2>where love starts with <span style="color: #F163FA">"Who-Ah-You"</span></h2>
  <br>
  <h2>sign up now to meet the love of your life</h2>
</div>
	
<a style="color:white;"><button  class="pink_button_block" style="margin-left:80%;"> setting</button></a>
	
	<%@ page import = "whoahyou.User" %>
	<%
		User user = (User) request.getAttribute("user");
	%>
	
<div> </div>	

<div class="big_container">
	<div class="card"></div>
  <div class="card">
  	
    <h1 class="title">New Profile</h1>
<!--  <jsp:include page="newProfilePic.jsp" />-->	
	<%
		String ssn = (String)request.getAttribute("ssn");
	%>
	<form method = post action = newProfile>
      <div class="input-container">
		<input type="hidden" name ="ssn" value = "<%=ssn %>"/>
        <input type="text" name= "profileID" id="profileID" required= "required">

        <label for="label">Profile ID</label>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
        <input type="text" name = "profileName" id="profileName" >
        <label for="label">Profile Name(optional)</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" name = "hairColor" id="hairColor" >
        <label for="label">Hair Color</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
		<h6 style="font-size:20px;">Age</h6>
		<br>
		<select class="age" name = "profileAge" Id="profileAge"><option value="select">select</option></select>
		<br><br>
        <div class="bar"></div>
      </div>
	 
	  <div class="input-container">
		<h6 style="font-size:20px;">Gender</h6>
		<br>
		  <select name = "gender" id="profileGender" required = "required">
				<option value= "select">select</option>
				<option value="male">male</option>
				<option value="female">female</option>
		  </select>
		  <br><br>
        <div class="bar"></div>
				
        <div class="bar"></div>
      </div>  
	   <div class="input-container">
			<h6 style="font-size:20px;">Weight</h6><br>
			<select name = "weight" class="weight" id="profileWeight"><option value="select">select</option></select>
		  <br><br>
        <div class="bar"></div>
      </div>
	  <div class="input-container">		
		 <h6 style="font-size:20px;">Height </h6><br>
		  feet <select name="feet" class="feet" id="profileFeet"><option value="select">select</option>
		  </select> inches <select name ="inches" id="profileInches"><option value="select">select</option>
		  <option>0</option><option>1</option><option>2</option><option>3</option><option>4</option>5</option>
		  <option>6</option><option>7</option><option>8</option><option>9</option><option>10</option><option>11</option>
		  </select>
		  <br><br>  
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
      <div class="input-container">
	   <h6 style="font-size:20px;">Interested in people within</h6>
			<br><br>
		  <select class="geoRange" Id="profileGeoDatingRange"><option value="select">select</option></select> mile(s)
		  <select name = "geoRange" class="geoRange" Id="profileGeoDatingRange"><option value="select">select</option></select> mile(s)
		  <br><br>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
			<br><br>
		  <h1 style="font-size:20px;"> Preferred age<h1><br>
		  <select class="DatingAgeFrom" name = "DatingAgeRangeStart" id="datingAgeFrom"><option value="select">select</option></select> to
		  <select class="DatingAgeFrom"  name="DatingAgeRangeEnd" id="datingAgeTo"><option value="select">select</option></select></h6>
		  <br><br>
			<div class="bar"></div>
        <div class="bar"></div>
      </div>
	  
	  <div style="margin-left:4.6%;">
	  <p style="font-size:20px;">Use the input and button below to add a hobby:</p>
		<br>
		<input type="text" id="hobby" style="margin-left:10%;"><button onclick="addHobbies()">add</button>
		<br><br>
		<div>
		<h5 style="font-size:17px; margin-top:-3%">Hobbies:</h5>
		
		<ul id="hobby_list" name="hobbies" style="font-size:17px;margin-left:55px;margin-top:2%;">
		</ul>
	  </div>
	</div>
	   <button class="pink_button_block" style="margin-left:40%;margin-top:20%;" onclick="verifyInput()"><span>done</span></button>
	</form>
	</div>
	</div>
	</div>
	  
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


	


	

</body>

</html>