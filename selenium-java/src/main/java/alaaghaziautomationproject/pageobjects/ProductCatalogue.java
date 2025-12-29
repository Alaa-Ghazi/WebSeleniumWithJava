package alaaghaziautomationproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import alaaghaziautomationproject.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	//This class for the products web page, and adding to the cart
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	By prodN = By.cssSelector(".inventory_item_name");
		

	public void selectProductAndAdd(List<String> desiredProducts) {

		waitVisbilityElement(prodN);
		
		List<WebElement> productNamesList = driver.findElements(By.cssSelector(".inventory_item_name"));
		List<WebElement> addButtons = driver.findElements(By.cssSelector(".btn_primary"));

	    productNamesList.stream()
	        .filter(p -> desiredProducts.stream()
	                .anyMatch(dp -> dp.equalsIgnoreCase(p.getText())))
	        .limit(2)
	        .forEach(p -> {
	            int index = productNamesList.indexOf(p);
	            addButtons.get(index).click();
	            System.out.println("Added to cart: " + p.getText());
	        });
	}


}
