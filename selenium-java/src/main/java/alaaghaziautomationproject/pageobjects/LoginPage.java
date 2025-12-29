package alaaghaziautomationproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import alaaghaziautomationproject.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	//This class for the URL and the login details in the web page.
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement userName;
	
    @FindBy(id = "password")
    WebElement userPassword;
    
    @FindBy(id = "login-button")
    WebElement button;
    
    @FindBy(xpath="//div[@class='error-message-container error']/h3")
    WebElement errorMessgae;
    
    public ProductCatalogue loginCredintials(String name, String password) {
    	userName.sendKeys(name);
    	userPassword.sendKeys(password);
    	button.click();
    	ProductCatalogue prod = new ProductCatalogue(driver);
    	return prod;
    }
	
    public void goToURL() {
    	 driver.get("https://www.saucedemo.com/");
    }
    
    public String getErrorMessageText() {
    	waitVisbilityOfWebElement(errorMessgae);
    	return errorMessgae.getText();
    }

}
