package seller;

import repository.EcommerceRepository;

public class SellerModel {

	public void putSellerDetailInRepo(String name, String number, String gst, String mail, String doorno, String street,
			String district, String postal, String country) {
		EcommerceRepository.getInstance().putSellerDetailInRepo(name,number,gst,mail,doorno,street,
				district,postal,country);
		
	}

}
