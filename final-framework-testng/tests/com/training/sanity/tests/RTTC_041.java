package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CategoriesAdminPOM;
import com.training.pom.DeleteCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class RTTC_041 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginAdminPOM;
	private static Properties properties;
	private static ProductPOM TSProductPOM;
	private CategoriesAdminPOM CategoryPOM;
	
  @Test
  public void f() throws InterruptedException {
	  
	  loginAdminPOM.sendUserName("admin");		
		loginAdminPOM.sendPassword("admin@123");
		loginAdminPOM.clickLoginBtn();
		Thread.sleep(5000);
		CategoryPOM.mouseOverCategryIcon();
		System.out.println("Test Sept 1");
		Thread.sleep(5000);
		TSProductPOM.clickgoToProduct();
		TSProductPOM.sendproductName("Integer vitae iaculis massa");
		Thread.sleep(3000);
		TSProductPOM.clickFilter();
		TSProductPOM.sendPrice(515);
		Thread.sleep(3000);
		TSProductPOM.clickFilter();
		TSProductPOM.selectStatus("Enabled");
		Thread.sleep(3000);
		TSProductPOM.clickFilter();
		TSProductPOM.sendModel("SKU-003");
		Thread.sleep(3000);
		TSProductPOM.clickFilter();
		TSProductPOM.sendQuantity("49");
		Thread.sleep(3000);
		TSProductPOM.clickFilter();
		TSProductPOM.selectImages("Enabled");
		Thread.sleep(3000);
		TSProductPOM.clickFilter();
		
		
  }

  @BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginAdminPOM = new LoginPOM(driver); 
		TSProductPOM = new ProductPOM(driver);
		CategoryPOM = new CategoriesAdminPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		 
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }


  @AfterMethod
  public void afterMethod() {
  }


  @AfterTest
  public void afterTest() {
  }

}
