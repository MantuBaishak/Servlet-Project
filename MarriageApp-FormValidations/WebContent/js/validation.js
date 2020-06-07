function validate(frm){
	
	//read form data
	let name=frm.pname.value;
	let age=frm.page.value;
	let flag=true;
	//get empty error message
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	//write client side form validation logic
	if(name==""){
		document.getElementById("pnameErr").innerHTML="Person name is required";
		frm.pname.focus();
		flag=false;
	}
	else if(name.length<5 || name.length>15){
		document.getElementById("pnameErr").innerHTML="person name must have min of 5 chars and max of 15 chars";
		frm.pname.focus();
		frm.pname.value="";
		flag=false;
	}
	if(age==""){
		document.getElementById("pageErr").innerHTML="person age is required";
		frm.page.focus();
		flag=false;
	}
	else if(isNaN(age)){
		document.getElementById("pageErr").innerHTML="person age must be numeric value";
		frm.page.focus();
		frm.page.value="";
		flag=false;
	}
	else if(age<1 || age>125){
		document.getElementById("pageErr").innerHTML="person age must be there 1 through 125";
		frm.page.focus();
		frm.page.value="";
		flag=false;
	}
	//change hidden box (vflag) value to "yes" indicating client side form validation are done
	alert("client side javaScript");
	frm.vflag.value="yes";
	return flag;
}//function()