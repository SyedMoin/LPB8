package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCategoryPOM{
	
	private WebDriver driver; 
	
	public DeleteCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//td[contains (., 'Electroni')]/preceding-sibling::td[@class='text-center']")
	private WebElement categoryItemToDelete; 
	
	public void clickCategoryItemToDelete() {
		System.out.println(categoryItemToDelete);
		this.categoryItemToDelete.click();
	}
	@FindBy(xpath="//button[@data-original-title='Delete']")
	private WebElement deleteItem;
	
	public void clickDeleteItem () {
		this.deleteItem.click();
	}
	
	@FindBy(xpath=" //div[@class='alert alert-success']")
	private WebElement successTextofDelete;
	
	public String getsuccessTextofDelete() {
		String actualMessage= this.successTextofDelete.getText();
		System.out.println("test"+ successTextofDelete);
		return actualMessage;
		
	}
			
}
