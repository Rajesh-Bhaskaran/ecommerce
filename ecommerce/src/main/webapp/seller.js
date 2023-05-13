/**
 * 
 */
function login(){
    var mid =document.getElementById("mid");
    var loginform=document.getElementById("loginform");
    var sellerRegistration=document.getElementById("sellerRegistration");
    if( loginform.style.display==='none')
    {
        loginform.style.display="block";
        mid.style.display="none";
        sellerRegistration.style.display="none";
    }
    else
    {
        loginform.style.display='none'
        mid.style.display="block";
    }
}

function seller(){
    var mid =document.getElementById("mid");
    var loginform=document.getElementById("loginform");
    var sellerRegistration=document.getElementById("sellerRegistration");
    if(sellerRegistration.style.display==="none"){
        loginform.style.display="none";
        mid.style.display="none";
        sellerRegistration.style.display="block";
    }
    else{
        sellerRegistration.style.display="none";
        mid.style.display="block";
    }

}

function submit(){
    let name=document.getElementById("name").value;
    let number=document.getElementById("mobile").value;
    let gst=document.getElementById("gst").value;
    let mail=document.getElementById("mail").value;
    let doorno=document.getElementById("doorno").value;
    let street=document.getElementById("street").value;
    let district=document.getElementById("district").value;
    let postal=document.getElementById("postal").value;
    let country=document.getElementById("country").value;
    let password=document.getElementById("password").value; 
    let repassword=document.getElementById("repassword").value;
    debugger;
    if(password!=repassword)
    {
		let message=document.getElementById("message");
		message.innerHTML='<span class="message">ReEnter-Valid-Password</span>';
	}
    else 
    {
	  var data ="name="+name+"&number="+number+"&gst="+gst+"&mail="+mail+"&doorno="+doorno+"&street="+street+"&district="+district+"&postal="+postal+"&country="+country+"&password="+password ;
      ajaxcall("POST","http://localhost:8080/ecommerce/Seller",data);
	}
    
}

function ajaxcall(methodType, url,data) {
	
	let promise = new Promise(function(resolve, reject) {
		const xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				resolve(JSON.parse(xhr.responseText));
			}
		}
		xhr.open(methodType, url);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(data);
	});
	return promise;
}