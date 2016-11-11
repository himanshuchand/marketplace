package login;

import org.openqa.selenium.By;



public class admin_login extends openselenium{
  


public void adminlogin() throws InterruptedException 
  {
	  
	driver.manage().window().maximize();
	driver.navigate().to("https://pratik.webkul.com/shopify-trunk/shopify-mp?hmac=bcb1a8020d635ef46a62099e33e6e29b39aae1a908d6ec66c038feba77917bbd&shop=himanshu-shop2.myshopify.com&signature=1e76991bf6e32104ca8f9338e4f34ed9&timestamp=1452522348");
	driver.findElement(By.xpath("//a/div")).click();
	Thread.sleep(1000);

  }
}
