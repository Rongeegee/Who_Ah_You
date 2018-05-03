<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

   
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.`min.css">
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div style="width:30%;margin-left:5%;">
	
		<h4 style="font-size:20px">upload a profile image(optional)</h4><br>
		<form action = newProfilePic enctype="multipart/form-data">
		<img src="images/defaultProfile.jpg" style="height:150px;width:120px;" id = "profilePic"/>
		<br><br>	
		<input name = "profilePic" type="file" accept="image/*" id="imgPath" onchange="uploadImg()"></form>
		<br><br><br>
	</div>
</body>
</html>