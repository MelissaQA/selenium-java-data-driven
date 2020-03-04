package org.automation.testingworld.base;

import java.io.IOException;

import org.automation.testingworld.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {

	public WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() throws Exception {
		
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "./Driver/internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.get(Utility.fetchPropertyValue("applicationURL").toString());
		
	}
	
	@AfterMethod
	public void closeDriverInstance() {
		
		driver.quit();
		
	}
	
}
