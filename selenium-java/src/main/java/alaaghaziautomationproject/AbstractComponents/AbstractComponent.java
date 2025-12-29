package alaaghaziautomationproject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import alaaghaziautomationproject.pageobjects.CartPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(css = ".shopping_cart_link")
    WebElement cartIcon;
    
	public void waitVisbilityElement(By FindBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitVisbilityOfWebElement(WebElement webEle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webEle));
	}
	
	public CartPage goToCartPage() {
		cartIcon.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

}
