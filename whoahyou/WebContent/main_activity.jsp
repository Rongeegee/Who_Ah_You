<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
 <title>Activities</title>
  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/style.css">
</head>
<body>

  

<!-- Pen Title-->
<div class="pen-title">
  <h1>Who-Ah-You</h1><h2>where love starts with <span style="color: #F163FA">"Who-Ah-You"</span></h2>
  <br>
  <h2>sign up now to meet the love of your life</h2>
</div>
	

	<a style="color:white;"><button  class="pink_button_block" style="margin-left:80%;">&nbsp setting</button></a>
	


<div class="big_container">
	<div class="card"></div>
		<div class="card">
		
			<div class="tabPane">
			  <button class="tabButton" onclick="tab('date')" id="dateButton">Dates</button>
			  <button class="tabButton" onclick="tab('like')" id="likeButton">Likes</button>
			  <button class="tabButton" onclick="tab('discover')" id="discoverButton">Discover</button>
			</div>

			<div id="date" class="pane">
			<!-- the following code is for the display of past date-->
			<h2 id="pastDateHeading">Past Date:<h2>
			  
								
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				 <h2 class="dateProfileName">Profile name</h2>
			  </div>
 
			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<h2  class="info">customer represenative</h2>
				<h2 class="info"> his/her rating</h2>
				<h2  class="info">your rating</h2>
				<h2  class="info">comment</h2>
			  </div>
			</div>
			
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				<h2  class="dateProfileName">Profile name</h2>
			  </div>

			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<h2  class="info">customer represenative</h2>
				<h2 class="info">his/her rating</h2>
				<h2  class="info">your rating</h2>
				<h2  class="info">comment</h2>
			  </div>
			</div>
			<!-- end of code for past date-->
			
			
			
			<!-- the following code is for the display of pending date that needs comment from customers-->
			<h2 id="pendingDateHeading">pending Date:<h2>
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				<h2  class="dateProfileName">Profile name</h2>
			  </div>

			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<br>
				<br>
				<textarea class="commentBox" rows="7" cols="80" name="comment" form="usrform">Please write a comment about your date here</textarea>
				<br>
				<button class="post_button">post</button>
			  </div>
			</div>
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				<h2  class="dateProfileName">Profile name</h2>
			  </div>

			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<br>
				<br>
				<textarea class="commentBox" rows="7" cols="80" name="comment" form="usrform">Please write a comment about your date here</textarea>
				<br>
				<button class="post_button">post</button>
			  </div>
			</div>
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				<h2  class="dateProfileName">Profile name</h2>
			  </div>

			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<br>
				<br>
				<textarea class="commentBox" rows="7" cols="80" name="comment" form="usrform">Please write a comment about your date here</textarea>
				<br>
				<button class="post_button">post</button>
			  </div>
			</div>
			
			
			
			
			
			
			<!-- the following code is for the display of future date-->
			<h2 id="futureDateHeading">Future Date:<h2>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div><div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			
			
			
			<!-- end of future code for future date-->
			
			
			
			
			
			</div>

			
			<!-- the following div with an "like" id is the like page-->
			<div id="like" class="pane" style="display:none">
			<h1 ID="likeHeading">People That You Like:</h2>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<button class="likeBackButton">like back</button>
				</div>
			    <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					
					<button class="likeBackButton">like back</button>
				</div>
				<div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<button class="likeBackButton">like back</button>
				</div>
				<div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<button class="likeBackButton">like back</button>
				</div>
				
				<h1 ID="likeHeading" style="margin-top:20%;">People That Like You:</h2>
				<div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<button class="undoLikeButton">undo like</button>
				</div>
			    <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					
					<button class="undoLikeButton">undo like</button>
				</div>
				<div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<button class="undoLikeButton">undo like</button>
				</div>
				<div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<button class="undoLikeButton">undo like</button>
				</div>
				
			</div>

			<div id="discover" class="pane" style="display:none">
			 <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2>
					<button class="likeProfileButton">like</button>					
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
					<button class="likeProfileButton">like</button>	
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
					<button class="likeProfileButton">like</button>	
			  </div>
			  
			  
			</div>

		</div>
	</div>	
</div>
	  
	  
  
  
		
</body>

 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script  src="js/index.js"></script>
</html>