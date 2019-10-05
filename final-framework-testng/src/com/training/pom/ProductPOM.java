package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPOM{
	
	private WebDriver driver; 
	
	public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}	
	@FindBy(linkText="Products")
	private WebElement goToProduct; 
	
	public void clickgoToProduct() {
		System.out.println("This is xPath of go to Product"+ goToProduct);
		this.goToProduct.click();
	}
	@FindBy(id ="input-name")
	private WebElement productName;
	
	public void sendproductName (String productName) {
		System.out.println("This is xPath of go to ProductName"+ productName);
		this.productName.sendKeys(productName);
	}
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	public void clickFilter() {
		this.filter.click();	
	}
	
	@FindBy(id="input-price")
	private WebElement price;
	
	public void sendPrice(int price) {
		
		this.price.sendKeys(String.valueOf(price));
	}
	@FindBy(id= "input-status")
	private WebElement status;
	
	public void selectStatus(String value) {
		WebElement address = driver.findElement(By.id("input-status"));
		System.out.println("Selected Status");
		Select addresslist = new Select(address);
		System.out.println("Selected Status1");
		addresslist.selectByVisibleText(value);
		System.out.println("Selected Status2");
	}
	@FindBy(id="input-model")
	private WebElement model;
	
	public void sendModel (String model) {
		this.model.sendKeys(model);
	}
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	public void sendQuantity (String quantity) {
		this.quantity.sendKeys(quantity);
	}
	@FindBy(id= "input-image")
	private WebElement images;
	
	public void selectImages(String imageValue) {
		WebElement imageAddress = driver.findElement(By.id("input-image"));
		Select addressList = new Select(imageAddress);
		addressList.selectByVisibleText(imageValue);
	}
}
