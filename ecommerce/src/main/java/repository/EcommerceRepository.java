package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Product_Category;
import dto.Promotion;

public class EcommerceRepository {
	Connection con;
	Statement st;
	private static EcommerceRepository repository;
	
	private EcommerceRepository() {
		try {
			//System.out.println("Hi 1");
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Hi 2");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root",
					"22101998Ms#");
			 //System.out.println("Hi 3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static EcommerceRepository getInstance() {
		if (repository == null)
			repository = new EcommerceRepository();

		return repository;
	}

	// Method To Get Product List In Home Page
	public List<Product_Category> getProductList() {
		List<Product_Category> list = new ArrayList<>();
		String query = "Select*From product_category";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			//System.out.println(rs);
			while (rs.next()) {
				int product_category_id = rs.getInt("product_category_id");
				//System.out.println(product_category_id);
				String product_category_name = rs.getString("category_name");
				//System.out.println(product_category_name);
				String product_category_image = rs.getString("category_image");
				//System.out.println(product_category_image);
				list.add(new Product_Category(product_category_id, product_category_name, product_category_image));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<Promotion> getPromotionList() {
		List<Promotion>promotion_list=new ArrayList<>();
		String query="Select*from promotion";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int promotion_id=rs.getInt("promotion_id");
				String name=rs.getString("name");
				String desc=rs.getString("description");
				String image=rs.getString("promotion_image");
				//System.out.println(image);
				promotion_list.add(new Promotion(promotion_id,name,desc,image));	
			}
			return promotion_list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return promotion_list;
		
		
	}


	public void putSellerDetailInRepo(String name, String number, String gst, String mail, String doorno, String street,
			String district, String postal, String country) {
		try {
			st=con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String query="INSERT INTO seller(seller_name,seller_mail,seller_mobile,gst) VALUES ('"+name+"','"+mail+"','"+number+"','"+gst+"');";
	      try {
			st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    //Getting Seller Id
	      String idQuery="SELECT seller_id FROM seller WHERE gst='"+gst+"';";
	      int sellerId=0;
	      try {
			ResultSet rs=st.executeQuery(idQuery);
			if(rs.next())
			sellerId=rs.getInt("seller_id");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	      
	      //Finding Seller Country Id And Inserting Into Address Table
	    String countryQuery="SELECT country_id FROM country WHERE country_name='"+country+"';";
	    try {
	    	ResultSet rs=st.executeQuery(countryQuery);
	    	int country_id=0;
	    	if(rs.next()) {
	    		String countryInsertQuery="INSERT INTO country(country_name) VALUES ('"+country+"');";
	    		st.execute(countryInsertQuery);
	    		rs=st.executeQuery(countryQuery);
	    		if(rs.next())
	    		country_id=rs.getInt("country_id");
	    	}else {
	    		country_id=rs.getInt("country_id");	
	    	}
	    	String addressInsertuery="INSERT INTO seller_address(door_no,address,district,postal_code,country_id) VALUES('"+doorno+"','"+street+"','"+district+"','"+postal+"','"+country_id+"');";
	    	st.execute(addressInsertuery);
	    	String addressIdquery="SELECT MAX(seller_address_id) FROM seller_address";
	    	ResultSet rsAddress=st.executeQuery(addressIdquery);
	    	int address_id=0;
	    	if(rsAddress.next())
	    	address_id=rsAddress.getInt(1);
	    	
	    	String addressId="UPDATE seller SET seller_address_id='"+address_id+"' WHERE gst='"+gst+"';";
	    	st.execute(addressId);
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	     
	}

}
