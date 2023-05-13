/**
 * 
 */
function home() {
	ajaxcall("GET", "http://localhost:8080/ecommerce/Homepage")
		.then(function(response) {
			var promotion = response.Promotion;
			var category = response.Product_Category;
			 //response[i].Image_Link
			var product_container = document.getElementById("category");
			var promotion_slide = document.getElementById("slide");
			for (let i = 0; i < category.length; i++) {
				product_container.innerHTML += `<div class="products_category"><img src = "${category[i].Image_Link}">
			                              <div class=product_category_name">${category[i].Product_Category_Name}</div><div>`
			}
			
			promotion_slide.innerHTML = ``;
			for (let i = 0; i < promotion.length; i++) {
				if (i == 0)
					{
						promotion_slide.innerHTML += `<div class="carousel-item active">
      <img src="${promotion[i].Image_Link}" class="d-block w-100" alt="...">
    </div>`
					}
					else{
						promotion_slide.innerHTML += `<div class="carousel-item ">
      <img src="${promotion[i].Image_Link}" class="d-block w-100" alt="...">
    </div>`
					}
			}
		}

		)
}

function login(){
	let userlogin=document.getElementById("userlog");
	if(userlogin.style.display=="none")
	  userlogin.style.display="block";
	else
	  userlogin.style.display="none"
}


function ajaxcall(methodType, url) {
	
	let promise = new Promise(function(resolve, reject) {
		const xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				resolve(JSON.parse(xhr.responseText));
			}
		}
		xhr.open(methodType, url);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send();
	});
	return promise;
}

function products(){
	//debugger;
	var dom=document.getElementsByClassName("searching");
	//dom=dom.closest("input");
	let searchElement=dom.value;
	window.location.href="product_list.html";
	let request=document.getElementById("req");
	request.innerHTML=`<div class="searchrequest">${searchElement}</div>`;
}