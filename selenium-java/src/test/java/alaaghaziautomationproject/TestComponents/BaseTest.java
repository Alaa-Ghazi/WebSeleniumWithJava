package alaaghaziautomationproject.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import alaaghaziautomationproject.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage login;
	
	//This method to read the driver name from the properties file
	public WebDriver intiliazeDriver() throws IOException {
		
		//properties class 
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/alaaghaziautomationproject/resources/GlobalData.properties ");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        
        System.out.println("The browser launched Successfully");
       
		} 
		
		 driver.manage().window().maximize();
		
		 return driver;
	}
	
	//Method for the data located in JSON file. 
	public List<HashMap<String, String>> getJSONDatatoMap(String filePath) throws IOException
	{
		//Read JSON to String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//String to HashMap 
		ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		
		return data;
	}
	
	//Method for taking screenshots
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot tc = (TakesScreenshot) driver;
		File sourceFile = tc.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "//reports//screenshots//" + testcaseName + ".png");
		FileUtils.copyFile(sourceFile, destFile);
		
		return System.getProperty("user.dir") + "//reports//screenshots//" + testcaseName + ".png";
	}
	
	
	
	@BeforeMethod
	public LoginPage launchApplication() throws IOException {
		driver = intiliazeDriver();
		login = new LoginPage(driver);
	        login.goToURL();
	        return login;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
