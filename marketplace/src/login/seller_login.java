package login;

import org.openqa.selenium.By;



public class seller_login extends login.openselenium {
  
  public void sellerlogin() throws InterruptedException 
  {
	  
//	  driver.navigate().to("https://pratik.webkul.com/shopify-trunk/shopify-mp/?sid=40");
	  driver.get(seller_login_path);
	  Thread.sleep(500);
	  driver.findElement(By.id("wk_email")).sendKeys("test2@webkul.com");
	  driver.findElement(By.id("wk_password")).sendKeys("webkul12#");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  

  }
}
