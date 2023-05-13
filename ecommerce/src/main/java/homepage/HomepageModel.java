package homepage;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dto.Product_Category;
import dto.Promotion;
import repository.EcommerceRepository;

public class HomepageModel {


	// Method To Get Product List In Home Page
	public JSONObject getProductList() {
		JSONObject homeobj = new JSONObject();
		JSONArray arr = new JSONArray();
		JSONArray promotion_Arr= new JSONArray();
		List<Product_Category> list = EcommerceRepository.getInstance().getProductList();
		List<Promotion>promotion_list=EcommerceRepository.getInstance().getPromotionList();
//		System.out.println(list.toString());
		for (Product_Category category : list) {
			JSONObject obj = new JSONObject();
			obj.put("Product_Category_Name", category.getProduct_category_name());
			obj.put("Image_Link", category.getProduct_category_image());
			arr.add(obj);
		}
		for(Promotion promo:promotion_list) {
			JSONObject obj = new JSONObject();
			String image = promo.getPromotion_image();
			System.out.println(image);
			obj.put("Image_Link", image);
			promotion_Arr.add(obj);
		}
		homeobj.put("Product_Category",arr);
		homeobj.put("Promotion",promotion_Arr);
		return homeobj;

	}

}
