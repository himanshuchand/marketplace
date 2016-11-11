package join_seller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;



public class z_help_joinseller extends login.openselenium{
  
	void create_account() throws  IOException, InterruptedException 
	  {
		SoftAssert s_assert= new SoftAssert();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean htlm_error =driver.switchTo().activeElement().equals(driver.findElement(By.id("wk_email")));
		if(htlm_error){
			s_assert.fail("HTML ERROR : enter an email \n" );
		}
		else
		{	
//			System.out.println("in else of  htlm_error");
			Thread.sleep(250);
			boolean error_exists= driver.findElements(By.cssSelector("div.error-data.error")).size()!=0;
			if(error_exists)
			{	
//				System.out.println("in error_exists");
				String js_error= driver.findElement(By.cssSelector("div.error-data.error")).getText();
				if(js_error.equals(""))
				{	
//					System.out.println("in error=''");
					check_mp_error();
				}	
				else
				{
					takescreenshot();
					s_assert.fail("The test failed to add seller because "+js_error +"\n" );
				}
			}
			else
			{	
//				System.out.println("in else of  error_exists");
				check_mp_error();
			}
		}	
		s_assert.assertAll();
		
	  }
	 void check_mp_error() throws IOException 
	  {	
		SoftAssert s_assert= new SoftAssert();
		boolean mp_error= driver.findElements(By.className("mp-error")).size()!=0;
		if(mp_error)
		{
//		System.out.println("in of  mp_error");
		String fail= driver.findElement(By.className("mp-error")).getText();	
		takescreenshot();
//		System.out.println("fail =" +fail);
			if(fail.equals(""))
			{	
//				System.out.println("in fail.equals('')");
				String title = driver.getCurrentUrl();
//				System.out.println("title =" +title);
				String[] part =title.split("=");
//				System.out.println("part1 = " +part[0]);
//				System.out.println("part2 = "  +part[1]);
				if(part[1].equals("signup"))
				{
					s_assert.fail("The test failed to add seller Nadshould have contained error");
				}
				takescreenshot();
			}
			else
			{
				s_assert.fail("The test failed to add seller because "+fail );
			}
		}
		else
		{	
			
			String title = driver.getCurrentUrl();
//			System.out.println("title =" +title);
			String[] part =title.split("=");
//			System.out.println("part1 = " +part[0]);
//			System.out.println("part2 = "  +part[1]);
			if(part[1].equals("signup"))
			{
				s_assert.fail("The test failed to add seller should have contained error");
			}
			takescreenshot();
		}
		s_assert.assertAll();
	  }
	 void takescreenshot() throws IOException 
	  {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		FileUtils.copyFile(scrFile, new File("/home/users/himanshu.chand/Desktop/errors/testng/addseller/"+date+".png"));
		
	  }
	
	

	public void confirm_password(String value)  {
		driver.findElement(By.id("wk_cpassword")).clear();
		driver.findElement(By.id("wk_cpassword")).sendKeys(value);
		
		
	}

	public void password(String value) {
		driver.findElement(By.id("wk_password")).clear();
		driver.findElement(By.id("wk_password")).sendKeys(value);
		
		
	}

	public void email(String value)  {
		
		driver.findElement(By.id("wk_email")).clear();
		driver.findElement(By.id("wk_email")).sendKeys(value);
		
		
	}

	

	public void seller_name(String value) throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.id("wk_seller_name")).clear();
		driver.findElement(By.id("wk_seller_name")).sendKeys(value);
		
		
	}
	public void  go_to_sellerside() throws InterruptedException {
		driver.navigate().to("https://pratik.webkul.com/shopify-trunk/shopify-mp/?sid=40");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[1]/div/div/div/a")).click();
		Thread.sleep(250);
	}
}
