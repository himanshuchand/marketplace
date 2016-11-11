package login;

import org.openqa.selenium.By;



public class admin_login extends openselenium{
  


public void adminlogin() throws InterruptedException 
  {
	  
	driver.manage().window().maximize();
	driver.navigate().to(admin_login_path);
	driver.findElement(By.xpath("//a/div")).click();
	Thread.sleep(1000);

  }
}
