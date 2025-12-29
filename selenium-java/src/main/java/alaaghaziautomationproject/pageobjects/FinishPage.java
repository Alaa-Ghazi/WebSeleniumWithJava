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

public class FinishPage extends AbstractComponent{
	 
	
	WebDriver driver;
	
	public FinishPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	  
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishBtn;

	  public ConfirmationPage clickFinish() {
		  waitVisbilityOfWebElement(finishBtn);
		  
		  finishBtn.click();
		  
		  ConfirmationPage cofirm = new ConfirmationPage(driver);
		  return cofirm;
	  }
	  
}
