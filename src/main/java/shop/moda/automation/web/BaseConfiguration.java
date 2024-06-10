package shop.moda.automation.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.testng.annotations.BeforeSuite;

public class BaseConfiguration {
	
	public void initEnvironment(){
		String marionetteDriverLocation =  "D:\\geckodriver\\wires.exe";
		System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);		
	}
	public WebDriver loadDriver(String url)
	{
		WebDriver driver = new MarionetteDriver();		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	/*public WebDriver closeDriver(WebDriver driver){
		driver.close();
		return driver;

		
	}*/
}
