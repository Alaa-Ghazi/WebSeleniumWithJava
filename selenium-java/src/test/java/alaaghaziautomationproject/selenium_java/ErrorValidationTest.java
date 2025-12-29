package alaaghaziautomationproject.selenium_java;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import alaaghaziautomationproject.TestComponents.BaseTest;
import alaaghaziautomationproject.pageobjects.CartPage;
import alaaghaziautomationproject.pageobjects.CheckoutPage;
import alaaghaziautomationproject.pageobjects.ConfirmationPage;
import alaaghaziautomationproject.pageobjects.FinishPage;
import alaaghaziautomationproject.pageobjects.LoginPage;
import alaaghaziautomationproject.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest{
	
	//The negative scenarios validation class

	@Test
	public void LoginErrorValidaction() throws IOException, InterruptedException {
		
		/*
		 * // Extract username String userName =
		 * driver.findElement(By.cssSelector("div.login_credentials"))
		 * .getText().split("\n")[1].trim(); System.out.println("Username: " +
		 * userName);
		 */
		  
		  // Extract password 
		  String userPassword =
		  driver.findElement(By.xpath("//*[contains(text(),'secret_sauce')]"))
		                         .getText().split(":")[1].trim();

          //--Login Credintials 
          login.loginCredintials("djdjdj", userPassword);

       
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", 
        		login.getErrorMessageText());
        }
	

	
}
