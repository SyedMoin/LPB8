package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class retailTest {

	private WebDriver driver;
	private String baseUrl;
	private ProductPagePOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new ProductPagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod 
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException  {
		loginPOM.sendUserName("moin4mailing@gmail.com");
		loginPOM.sendPassword("test123");
		loginPOM.clickLoginBtn();
		loginPOM.clickHome();
		loginPOM.clickaddProduct();
		System.out.println("Test Sept 1");
		
		loginPOM.clickaddToCart(); 
		System.out.println("Test Sept 2");
		Thread.sleep(5000);
		
		loginPOM.clickgoToWishlist();
		
		System.out.println("Test Sept 3");
		
		loginPOM.clickremProd();
		System.out.println("Test4");
		loginPOM.clickrefresh();
		Thread.sleep(10000);

	}
}
