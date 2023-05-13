package dto;

public class Promotion {
	private String name;
	private String description;
	private String promotion_image;
	private int id;

	public Promotion(int id,String name,String description,String promotion_image) {
		 this.id=id;
         this.name=name;
         this.description=description;
         this.promotion_image=promotion_image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPromotion_image() {
		return promotion_image;
	}

	public void setPromotion_image(String promotion_image) {
		this.promotion_image = promotion_image;
	}
}
