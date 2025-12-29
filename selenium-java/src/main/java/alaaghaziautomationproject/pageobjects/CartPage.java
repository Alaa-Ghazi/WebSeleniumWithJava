package alaaghaziautomationproject.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import alaaghaziautomationproject.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	//This class is for cart web page.
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By prodN = By.cssSelector(".inventory_item_name");
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
    
	 //-- Compare the expected products with the actual ones selected from the previous page
	      
	  public List<String> selectedProducts(List<String> desiredProducts) throws InterruptedException {
		  
		  waitVisbilityElement(prodN);

		  List<WebElement> productNamesList = driver.findElements(By.cssSelector(".inventory_item_name"));
		  List<String> selected = new ArrayList<>();
		  
		  for (int i = 0; i < productNamesList.size(); i++) {
	          String name = productNamesList.get(i).getText();
	          if (desiredProducts.contains(name)) {
	               selected.add(name);
	          }else {
	        	  System.out.println("FAILED- Not in expected list"); 
	          }
	      }
		  return selected;  
	  }
	      
	  public CheckoutPage checkOut() {
		  checkoutBtn.click();
		  CheckoutPage checkout = new CheckoutPage(driver);
		  return checkout;
	  }
	      

}
