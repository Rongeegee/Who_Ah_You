


function loginErrorMessage(){
	document.getElementById("errorLoginMes").style.display = "block";
}


/**  the following function display a drop down box from a value to another value $**/
$(function(){
    var $select = $(".age");
    for (i=18;i<=100;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});

$(function(){
    var $select = $(".weight");
    for (i=80;i<=300;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});

$(function(){
    var $select = $(".feet");
    for (i=2;i<=8;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});



$(function(){
    var $select = $(".geoRange");
    for (i=1;i<=100;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});

$(function(){
    var $select = $(".DatingAgeFrom");
    for (i=18;i<=100;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});

$(function(){
    var $select = $(".DatingAgeTo");
    for (i=18;i<=100;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});

//The verifyInput function verifies if the user has entered all the required data on the new_profile page (The page that users make a new profile)
function verifyInput(){
	var missingData = false;
	var mesOnMissingInput = "Please select the data for ";
	var numOfMissingData = 0;
	if(document.getElementById("profileID").value == ""){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "profile ID";
		numOfMissingData++;
	}
	
	if(document.getElementById("profileCity").value == ""){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "city";
		numOfMissingData++
	}
	
	if(document.getElementById("profileState").value == ""){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "state";
		numOfMissingData++;
	}
	
	if(document.getElementById("profileAge").value == "select"){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "age";
		numOfMissingData++;
	}
	
	if(document.getElementById("profileGender").value == "select"){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "gender";
		numOfMissingData++;
	}
	if(document.getElementById("profileWeight").value == "select"){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "weight";
		numOfMissingData++;
	}
	if(document.getElementById("profileInches").value == "select"){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "inches";
		numOfMissingData++;
	}
	if(document.getElementById("profileGeoDatingRange").value == "select"){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "geo-dating range";
		numOfMissingData++;
	}
	if(document.getElementById("datingAgeFrom").value == "select" || document.getElementById("datingAgeTo").value == "select" ){
		missingData = true;
		if(numOfMissingData > 0){
			mesOnMissingInput += ", ";
		}
		mesOnMissingInput += "prefferred dating age";
		numOfMissingData++;
	}
	
	if(missingData == true){
		alert(mesOnMissingInput);
	}
	
	if(document.getElementById("datingAgeFrom").value > document.getElementById("datingAgeTo").value){
		alert("invalid input for geo-dating range");
	}
}


//the following codes are to add hobby into the list of hobby
var hobbies = [];

function addHobbies() {
   var txtVal = document.getElementById('hobby').value;
		if(txtVal != ""){
		var listNode = document.getElementById('hobby_list'),
			liNode = document.createElement("LI"),
			txtNode = document.createTextNode(txtVal);
		
		liNode.appendChild(txtNode);
		listNode.appendChild(liNode);
		document.getElementById('hobby').value = "";
		hobbies.push(txtVal);
		}
}

//the following code is to upload a profile
function uploadImg(){
		var imagePath = document.getElementById("imgPath");
		var fReader = new FileReader();
		fReader.readAsDataURL(imagePath.files[0]);
		fReader.onloadend = function(event){
		var img = document.getElementById("profilePic");
		img.src = event.target.result;
		}
		//i might need to extract the file path from the code above if needed
}

//the following function is to build the tab pane

function tab(tab) {
    var i;
    var x = document.getElementsByClassName("pane");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    document.getElementById(tab).style.display = "block";  
}