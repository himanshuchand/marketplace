package login;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class   openselenium extends files.file{
  
	public static WebDriver driver ;
	@BeforeSuite
	public void generatecsv() throws IOException
	{
		CreateCSV.create_csv_for_joinseller();
	}
	@BeforeMethod
	public void before_test()
	{
		System.setProperty("webdriver.gecko.driver", gecko_path);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.manage().window().maximize();	
	}
	
	@AfterMethod
	public void after_test() throws InterruptedException, FileNotFoundException 
	{	
		Thread.sleep(2000);
//		driver.quit();
//		System.setOut(new PrintStream(new FileOutputStream("/home/users/himanshu.chand/Documents/marketplace/console.out")));
		
	}
	
 
 }

