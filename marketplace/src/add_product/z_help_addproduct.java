package add_product;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


public class z_help_addproduct extends login.openselenium {
  

	  void goto_add_product() throws InterruptedException 
		{	
			driver.manage().window().maximize();
			login.admin_login a= new login.admin_login();
			a.adminlogin();
			driver.findElement(By.cssSelector("a.list-group-item.admin-product-btn")).click();
			driver.findElement(By.id("add-product")).click();					
		}
	  void normal_product() 
		{
			
			List<WebElement> product_type_select= driver.findElements(By.cssSelector("span.mp-padding-right.radio-option"));
						
				product_type_select.get(0).click();
			
		}
	  void seller_email() throws InterruptedException 
		{
		  SoftAssert s_assert= new SoftAssert();
		  driver.findElement(By.id("seller_email")).clear();
		  driver.findElement(By.id("seller_email")).click();
		  String sellerlist1 =  driver.findElement(By.id("ui-id-3")).getText();
		  String sellerlist2 =  driver.findElement(By.id("ui-id-5")).getText();
		  String[] part1 = sellerlist1.split("\n");
		  String[] part2 = sellerlist2.split("\n");
		  boolean x= part1[0].contains("@");
		  boolean y= part2[0].contains("@");
		  if(x)
		  {
			  
			  driver.findElement(By.id("seller_email")).sendKeys(part1[0]);
			  
			  
		  }
		  else if(y)
		  {
			  
			  driver.findElement(By.id("seller_email")).sendKeys(part2[0]);
			 
			  
		  }else
		  {
			  s_assert.fail("Not able to add seller form dropdown seller disapproved/disabled");
		  }
			
		}
	  void product_name(String value) 
	{
		driver.findElement(By.id("product_name")).clear();
		driver.findElement(By.id("product_name")).sendKeys(value);
		
	}

	  void product_type(String value) {
		
		driver.findElement(By.id("product_type")).clear();
		driver.findElement(By.id("product_type")).sendKeys(value);
		
	}

	  void product_description(String value) {
		 driver.switchTo().frame("product_desc_ifr");
		  driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(value);
		  driver.switchTo().defaultContent();
		
	}

	  void product_tags(String value) 
	 {
		
//		System.out.println("tags left");
	}

	  void product_weight(String value) {
		
		driver.findElement(By.id("weight")).clear();
		driver.findElement(By.id("weight")).sendKeys(value);
	}

	  void product_shipping(String is_shipping, int user_type) {
		
		
		List <WebElement> shipping_checkbox= driver.findElements(By.cssSelector("input.chkbox.check-option.hidden"));
		if(is_shipping.equals("1"))
		{
			if(shipping_checkbox.get(0).isSelected())
			{
				
			}
			else
			{	
				if(user_type==1)
				{
//					System.out.print("dfgh");
					driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[3]/div/form/div[6]/div[3]/div/label/span[1]")).click();	
				}
				else
				{
					driver.findElement(By.xpath("//form[@id='mp-form']/div[5]/div[3]/div/label/span[1]")).click();	
				}				
			}
		}
		else if(is_shipping.equals("0"))
		{
			if(shipping_checkbox.get(0).isSelected())
			{
				if(user_type==1)
				{
//					System.out.print("d12212112fgh");
					driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[3]/div/form/div[6]/div[3]/div/label/span[1]")).click();	
				}
				else
				{
					driver.findElement(By.xpath("//form[@id='mp-form']/div[5]/div[3]/div/label/span[1]")).click();	
				}	
			}
			
		}
	}

	  void product_price(String value) {
		
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys(value);
	}

	  void product_compare_price(String value) {
		
		driver.findElement(By.id("comp_price")).clear();
		driver.findElement(By.id("comp_price")).sendKeys(value);
	}

	  void product_tax(String value, int user_type) {
		
		List <WebElement> a= driver.findElements(By.cssSelector("input.chkbox.check-option.hidden"));
		if(value.equals("1"))
		{
			if(a.get(1).isSelected())
			{
				
			}
			else
			{
				if(user_type==1)
				{
					driver.findElement(By.cssSelector("html body div.wrapper div.container div.row div.col-lg-9.col-md-9.col-sm-11.mp-no-padding div.sub-container form#mp-form.admin-add-prod-form.normal-form.mp-margin-top div div.form-group.mp-margin div.checkbox label.mp-no-padding span.checkbox-icon")).click();				
				}
				else
				{
					driver.findElement(By.cssSelector("html body div.wrapper div.container div.row div.col-lg-9.col-md-9.col-sm-11.mp-no-padding div.sub-container form#mp-form.add-prod-form.normal-form.mp-margin-top div div.form-group.mp-margin div.checkbox label.mp-no-padding span.fa.mp-fa-sm.mp-wpx-16.mp-theme-color")).click();
				}
			}
		}
		if(value.equals("0"))
		{
			if(a.get(1).isSelected())
			{
				if(user_type==1)
				{
					driver.findElement(By.cssSelector("html body div.wrapper div.container div.row div.col-lg-9.col-md-9.col-sm-11.mp-no-padding div.sub-container form#mp-form.admin-add-prod-form.normal-form.mp-margin-top div div.form-group.mp-margin div.checkbox label.mp-no-padding span.checkbox-icon")).click();
				}
				else
				{
					driver.findElement(By.cssSelector("html body div.wrapper div.container div.row div.col-lg-9.col-md-9.col-sm-11.mp-no-padding div.sub-container form#mp-form.add-prod-form.normal-form.mp-margin-top div div.form-group.mp-margin div.checkbox label.mp-no-padding span.fa.mp-fa-sm.mp-wpx-16.mp-theme-color")).click();

				}
			}
		}
	}

	  void product_sku(String value) {
		
		driver.findElement(By.id("sku")).clear();
		driver.findElement(By.id("sku")).sendKeys(value);
	}

	  void product_barcode(String value) {
		
		driver.findElement(By.id("barcode")).clear();
		driver.findElement(By.id("barcode")).sendKeys(value);
	}

	  void product_inventory(String inventory, String quantity) throws InterruptedException {
		
		driver.findElement(By.id("track_inventory_btn")).click();
		Thread.sleep(250);
		if(inventory.equals("1"))
		{
			driver.findElement(By.xpath("//div[@id='track_inventory_div']/div/ul/li[2]")).click();
			product_quality(quantity);
		}
		else if(inventory.equals("0"))
		{
			driver.findElement(By.xpath("//div[@id='track_inventory_div']/div/ul/li[1]")).click();
		}
		
	}

	  void product_quality(String value) {
		driver.findElement(By.id("quantity")).clear();
		driver.findElement(By.id("quantity")).sendKeys(value);
	}

	  void product_image(String value) throws InterruptedException {
		
		driver.findElement(By.id("add_img")).click();
		Thread.sleep(250);
		driver.findElement(By.id("images0")).sendKeys(value);
	}

	  void save() throws  InterruptedException, IOException 
	{
		
			
		driver.findElement(By.id("prod-form-save-btn")).click();
		SoftAssert s_assert= new SoftAssert();
		boolean jserror= driver.findElements(By.xpath("(//div[@id=''])[2]")).size()!=0;
		if(jserror)
		{	
			String js_error= driver.findElement(By.xpath("(//div[@id=''])[2]")).getText();
			if(js_error.equals(""))
			{	
				check_mp_error();
			}	
			else
			{
				takescreenshot();
				s_assert.fail("The test failed to add product because "+js_error +"\n" );
			}
		}
		else
		{	
			check_mp_error();
		}
		s_assert.assertAll();
		
	}
	  void check_mp_error() throws IOException 
	{	SoftAssert s_assert= new SoftAssert();
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
				s_assert.fail("The test failed to add product because "+fail );
			}
		}
		else
		{
			takescreenshot();
		}
		s_assert.assertAll();
	}

	  void takescreenshot() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		FileUtils.copyFile(scrFile, new File(screenshot_path+date+".png"));
		
	}
	public void goto_add_product_sellerside() throws InterruptedException {
		login.seller_login a =new login.seller_login();
		a.sellerlogin();
		Thread.sleep(1000);
		driver.findElement(By.id("add-product")).click();
	}
	
}
