package alaaghaziautomationproject.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import alaaghaziautomationproject.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	//This class is for checkout web page.
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	WebElement firstName; 
	
	@FindBy(id = "last-name")
	WebElement lastName; 
	
	@FindBy(id = "postal-code")
	WebElement postalCode; 
	
	@FindBy(css = ".submit-button")
	WebElement submitBtn;
      
	  
	  public void detailsFill(String fname, String lname, String postal) {
		  
		  waitVisbilityOfWebElement(firstName);
		  
		  firstName.sendKeys(fname);
		  lastName.sendKeys(lname);
		  postalCode.sendKeys(postal);
		
	  }
	  
	  public FinishPage clickCheckout() {
		  submitBtn.click();
		  FinishPage finish = new FinishPage(driver);
		  return finish;
	  }
	  
}
