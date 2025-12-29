package alaaghaziautomationproject.selenium_java;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import alaaghaziautomationproject.TestComponents.BaseTest;
import alaaghaziautomationproject.pageobjects.CartPage;
import alaaghaziautomationproject.pageobjects.CheckoutPage;
import alaaghaziautomationproject.pageobjects.ConfirmationPage;
import alaaghaziautomationproject.pageobjects.FinishPage;
import alaaghaziautomationproject.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndTest extends BaseTest{

	
	@Test(dataProvider = "getLoginData")
	public void submitOrder1(HashMap<String, String> input) throws IOException, InterruptedException {
		
		  
		/*
		 * //User details for the checkout String firstName = "Alaa"; String lastName =
		 * "Ghazi"; String postalCode = "203333";
		 */

          //--Login Credentials 
          ProductCatalogue poductCatalogue = login.loginCredintials(input.get("username"), input.get("password"));
          System.out.println("Login Success");
         
         // Desired products
         List<String> desiredProducts = Arrays.asList( "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt" );
      
        poductCatalogue.selectProductAndAdd(desiredProducts); // Select the product names on the page and click Add to cart
        CartPage cartpage = poductCatalogue.goToCartPage();

        List<String> selectedProd = cartpage.selectedProducts(desiredProducts);
        Assert.assertEquals(selectedProd, desiredProducts, "Mismatch between expected and actual selected products!");

        CheckoutPage checkout = cartpage.checkOut();
        checkout.detailsFill(input.get("firstName"), input.get("lastName"), input.get("postalCode"));
       
        FinishPage finish = checkout.clickCheckout();
        
        ConfirmationPage confirmPage = finish.clickFinish();
        String confirmMesg = confirmPage.getMessage();

	  Assert.assertEquals("Thank you for your order!", confirmMesg);
	  }
	
	
		
		  @DataProvider 
		  public Object[][] getLoginData() throws IOException{ 
			
         List<HashMap<String, String>> data = getJSONDatatoMap(System.getProperty("user.dir") + 
				"//src//test//java//alaaghaziautomationproject//data//purchaseOrder.json");
         
		  return new Object[][] {{data.get(0)}};
		  
		  }
		 
}
