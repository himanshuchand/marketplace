package add_product;

import java.io.IOException;


import org.testng.annotations.Test;

public class add_products extends login.openselenium

{
  @Test(dataProviderClass=data_provider.z_data_provider.class,dataProvider="add_product")
public void test_add_product(String data) throws InterruptedException, IOException 
  {
	  int user_type=1; //for admin user_type=1 and for seller user_type=0
	  String strippeddata = data.replaceAll("\"", "");
	  String value[]= strippeddata.split(",");
	  add_product.z_help_addproduct a= new add_product.z_help_addproduct();
	  a.goto_add_product();
	  a.normal_product();
	  a.seller_email();
	  a.product_name(value[0]);
	  a.product_type(value[1]);
	  a.product_description(value[2]);
	  a.product_tags(value[3]);
	  a.product_weight(value[4]);
	  a.product_shipping(value[5], user_type);
	  a.product_price(value[6]);
	  a.product_compare_price(value[7]);
	  a.product_tax(value[8], user_type);
	  a.product_sku(value[9]);
	  a.product_barcode(value[10]);
	  a.product_inventory(value[11], value[12]);
	  a.product_image(value[13]);
	  a.save();
  
  }
 

}
