package com.training.pom;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPagePOM {
	private WebDriver driver; 
	public ProductPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input [@class='btn btn-primary']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='http://retail.upskills.in']//span")
	private WebElement home;
	
	@FindBy(linkText="Integer Vitae Iaculis Massa")
	private WebElement addProduct;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private  WebElement addToCart;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	public   WebElement goToWish;
	
	@FindBy(xpath="//i[@class='fa fa-times-circle']")
	private  WebElement remProd;
	
	@FindBy(xpath="//i[@class='fa fa-refresh']")
	public WebElement refresh;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickHome() {
		this.home.click(); 
	}
	public void clickaddProduct() {
		this.addProduct.click(); 
	}
	public void clickaddToCart() {
		this.addToCart.click(); 
	}
	public void clickgoToWishlist () {
		System.out.println("This is a test print sept");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		//Actions act = new Actions(driver);
		//act.moveToElement(goToWish).build().perform();
			
			System.out.println("This is to verify the wishlist");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", goToWish);
			
	}
	public void clickremProd() {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	this.remProd.click();
	}
	
	public void clickrefresh() {
		this.refresh.click();
	}
	//sleep after this 
	
}
