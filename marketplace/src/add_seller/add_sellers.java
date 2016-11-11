package add_seller;

import java.io.IOException;

import org.testng.annotations.Test;

public class add_sellers extends login.openselenium{
@Test(dataProviderClass=data_provider.z_data_provider.class,dataProvider="add_seller")
  public void test_add_seller(String data) throws InterruptedException, IOException {
	
		String strippeddata = data.replaceAll("\"", "");
		String value[]= strippeddata.split(",");
		  
		  add_seller.z_help_addseller addseller= new add_seller.z_help_addseller();
		  addseller.go_to_addseller();
		  addseller.seller_name(value[1]);
		  addseller.seller_shop_name(value[2]);
		  addseller.email(value[3]);
		  addseller.password(value[4]);
		  addseller.confirm_password(value[5]);
		  addseller.country(value[6], value[7]);
		  addseller.city(value[8]);
		  addseller.seller_contact(value[9]);
		  addseller.seller_short_dec(value[10]);
		  addseller.seller_desc(value[11]);
		  addseller.seller_policy(value[12]);
		  addseller.create_account();
	
	
	
  }

}
