package join_seller;

import java.io.IOException;

import org.testng.annotations.Test;


public class join_sellers extends login.openselenium{
@Test(dataProviderClass=data_provider.z_data_provider.class,dataProvider="join_seller")
  public void test_join_seller(String data) throws InterruptedException, IOException {
	
		  String strippeddata = data.replaceAll("\"", "");
		  String value[]= strippeddata.split(",");
		  
		  join_seller.z_help_joinseller addseller = new join_seller.z_help_joinseller();
		  addseller.go_to_sellerside();
		  
		  addseller.seller_name(value[1]);
		  addseller.email(value[2]);
		  addseller.password(value[3]);
		  addseller.confirm_password(value[4]);
//		  addseller.create_account();
	
	
	
  }

}
