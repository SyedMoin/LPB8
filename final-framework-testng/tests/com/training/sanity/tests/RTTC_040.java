package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CategoriesAdminPOM;
import com.training.pom.DeleteCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_040 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginAdminPOM;
	private CategoriesAdminPOM CategoryPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private DeleteCategoryPOM TSDeleteCategory;

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
		TSDeleteCategory = new DeleteCategoryPOM(driver);
		
		CategoryPOM = new CategoriesAdminPOM(driver);
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
		loginAdminPOM.sendUserName("admin");		
		loginAdminPOM.sendPassword("admin@123");
		loginAdminPOM.clickLoginBtn();
		Thread.sleep(5000);
		
		
		CategoryPOM.mouseOverCategryIcon();
		System.out.println("Test Sept 1");
		Thread.sleep(5000);
		CategoryPOM.clickCategoryList();
		System.out.println("Test Sept 2");
		Thread.sleep(5000);
	//	CategoryPOM.clickCheckBox();
		//Thread.sleep(5000);
		TSDeleteCategory.clickCategoryItemToDelete();
		System.out.println("Test Sept 3");
		TSDeleteCategory.clickDeleteItem();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		System.out.println("Test Sept 4");
		TSDeleteCategory.getsuccessTextofDelete();
		String expectedMessage = "Success: You have modified categories!";
		String actualSuccessMessage = TSDeleteCategory.getsuccessTextofDelete();
		System.out.println("Testing Actual Message is commited" +actualSuccessMessage);
		System.out.println("Testing Expected Message " + expectedMessage);
		Boolean res= actualSuccessMessage.contains(expectedMessage);
		System.out.println("Result "+res);
		Assert.assertTrue(actualSuccessMessage.contains(expectedMessage));
		//Assert.assertTrue(actualSuccessMessage.contains(expectedMessage));
		System.out.println("Testing Expected Message " + expectedMessage);
	

	}
}
