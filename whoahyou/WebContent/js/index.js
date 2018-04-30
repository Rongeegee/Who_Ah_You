$('.toggle').on('click', function() {
  $('.container').stop().addClass('active');
});

$('.close').on('click', function() {
  $('.container').stop().removeClass('active');
});


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
    var $select = $(".inches");
    for (i=1;i<=10;i++){
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
		
		//i might need to extract the file path from the code above if needed
}

}