package dto;

public class Product_Category {
	private int product_category_id;
	private String product_category_name;
	private String product_category_image;

	public Product_Category(int product_category_id, String product_category_name, String product_category_image) {
		this.product_category_id = product_category_id;
		this.product_category_name = product_category_name;
		this.product_category_image = product_category_image;

	}

	public int getProduct_category_id() {
		return product_category_id;
	}

	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}

	public String getProduct_category_name() {
		return product_category_name;
	}

	public void setProduct_category_name(String product_category_name) {
		this.product_category_name = product_category_name;
	}

	public String getProduct_category_image() {
		return product_category_image;
	}

	public void setProduct_category_image(String product_category_image) {
		this.product_category_image = product_category_image;
	}
}
