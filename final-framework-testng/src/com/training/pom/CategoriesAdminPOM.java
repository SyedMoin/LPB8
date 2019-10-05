package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesAdminPOM {
	private WebDriver driver; 
	public CategoriesAdminPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement categoryIcon;
	
	public void mouseOverCategryIcon () {
		System.out.println("Test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
		Actions act = new Actions(driver);
		act.moveToElement(categoryIcon).build().perform();
	}
	
	@FindBy(partialLinkText="Categorie")
	private  WebElement categoryList;
	
	public void clickCategoryList() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
		Actions act = new Actions(driver);
		act.moveToElement(categoryList).click().build().perform();
	}
	
	@FindBy(xpath="//table [@class ='table table-bordered table-hover']//input[@name='selected[]']")
	
	private WebElement checkBox;
	
	public void clickCheckBox () {
		this.checkBox.click();
	}
	
	
}
