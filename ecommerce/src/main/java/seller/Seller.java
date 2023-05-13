package seller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Seller
 */
@WebServlet("/Seller")
public class Seller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*let name=document.getElementById("name").value;
    let number=document.getElementById("mobile").value;
    let gst=document.getElementById("gst").value;
    let mail=document.getElementById("mail").value;
    let doorno=document.getElementById("doorno").value;
    let street=document.getElementById("street").value;
    let district=document.getElementById("district").value;
    let postal=document.getElementById("postal").value;
    let country=document.getElementById("country").value; */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		String gst=request.getParameter("gst");
		String mail=request.getParameter("mail");
		String doorno=request.getParameter("doorno");
		String street=request.getParameter("street");
		String district=request.getParameter("district");
		String postal=request.getParameter("postal");
		String country=request.getParameter("country");
		
		SellerModel sellermodel= new SellerModel();
		//Method Calling To Passing Seller To Repository
		sellermodel.putSellerDetailInRepo(name,number,gst,mail,doorno,street,district,postal,country);
	}

}
