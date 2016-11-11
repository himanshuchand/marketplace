package add_seller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import login.admin_login;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;




public class z_help_addseller extends login.openselenium{
  
	public void create_account() throws InterruptedException, IOException {
		SoftAssert s_assert= new SoftAssert();
		driver.findElement(By.id("add_seller_btn")).click();
		Thread.sleep(250);
		String html_error= driver.findElement(By.id("seller_email")).getAttribute("aria-describedby");
		if(html_error==null)
		{
			
			boolean error_exists= driver.findElements(By.xpath("//form[@id='add_seller_form']/div[8]/div")).size()!=0;
			if(error_exists)
			{	
				String js_error= driver.findElement(By.xpath("//form[@id='add_seller_form']/div[8]/div")).getText();
				if(js_error.equals(""))
				{	
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
				check_mp_error();
			}
		}
		else
		{
			
			takescreenshot();
			s_assert.fail("The test failed to add seller because of email-id");
		}
		s_assert.assertAll();
	}
	void check_mp_error() throws IOException {	
		SoftAssert s_assert= new SoftAssert();
		boolean mp_error= driver.findElements(By.className("mp-error")).size()!=0;
		if(mp_error)
		{
			String fail= driver.findElement(By.cssSelector("span.mp-error-msg")).getText();	
			takescreenshot();
			if(fail.equals(""))
			{
				takescreenshot();
			}
			else
			{
				s_assert.fail("The test failed to add seller because "+fail );
			}
		}
		else
		{
			takescreenshot();
		}
		s_assert.assertAll();
	}
	void takescreenshot() throws IOException 
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		FileUtils.copyFile(scrFile, new File(screenshot_path+date+".png"));
		
	}
	

	public void confirm_password(String value) throws InterruptedException {
		driver.findElement(By.id("seller_cpassword")).clear();
		driver.findElement(By.id("seller_cpassword")).sendKeys("webkul12#");
		Thread.sleep(250);
		
	}

	public void password(String value) throws InterruptedException {
		driver.findElement(By.id("seller_password")).clear();
		driver.findElement(By.id("seller_password")).sendKeys(value);
		Thread.sleep(250);
		
	}

	public void email(String value) throws InterruptedException {
		
		driver.findElement(By.id("seller_email")).clear();
		driver.findElement(By.id("seller_email")).sendKeys(value);
		Thread.sleep(250);
		
	}

	public void seller_shop_name(String value) throws InterruptedException {
		
		driver.findElement(By.id("store_name")).clear();
		driver.findElement(By.id("store_name")).sendKeys(value);
		Thread.sleep(250);
		
	}

	public void seller_name(String value) throws InterruptedException {
		driver.findElement(By.id("seller_name")).clear();
		driver.findElement(By.id("seller_name")).sendKeys(value);
		Thread.sleep(250);
		
	}
	public void  go_to_addseller() throws InterruptedException {
		admin_login a= new admin_login();
		  a.adminlogin();
		  driver.findElement(By.cssSelector("a.list-group-item.admin-seller-btn")).click();
		  Thread.sleep(500);
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]/div[3]/div/div/div[3]/a")));
		  element.click();
		  
		
	}
	public void country(String value, String state) throws InterruptedException {
		// TODO Auto-generated method stub id_country 
		
		Select dropdown = new Select(driver.findElement(By.id("id_country")));
		dropdown.selectByVisibleText(value);
		Thread.sleep(1500);
	
		List<WebElement> m = driver.findElements(By.id("id_state"));
		if(m.get(0)!=null)
		{
			state(state);
		}
		
		
	}
	public void state(String value) {
		Select dropdown = new Select(driver.findElement(By.id("id_state")));
		dropdown.selectByVisibleText(value);
		
	}
	public void seller_contact(String value) throws InterruptedException {
		driver.findElement(By.id("contact")).clear();
		driver.findElement(By.id("contact")).sendKeys(value);
		Thread.sleep(250);
		
	}
	public void seller_short_dec(String short_dec) throws InterruptedException {
		driver.findElement(By.id("short_desc")).clear();
		driver.findElement(By.id("short_desc")).sendKeys(short_dec);
		Thread.sleep(250);
		
	}
	public void seller_policy(String value) throws InterruptedException {
		driver.findElement(By.id("policy")).clear();
		driver.findElement(By.id("policy")).sendKeys(value);
		Thread.sleep(250);
		
	}
	public void city(String city) throws InterruptedException {
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(city);
		Thread.sleep(250);
		
	}
	public void seller_desc(String value) throws InterruptedException {
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(value);
		Thread.sleep(250);
		
	}
}
