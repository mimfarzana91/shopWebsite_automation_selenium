package shop.moda.automation.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import shop.moda.automation.service.impl.CustomerLoginServiceImpl;
import shop.moda.automation.service.interfaces.CustomerLoginService;

public class CustomerLogin {

	private BaseConfiguration baseConfig=new BaseConfiguration();
	CustomerLoginService customerLogin = new CustomerLoginServiceImpl();
	private WebDriver driver=null;
	
	@BeforeSuite
	public void initEnvironment(){
		baseConfig.initEnvironment();
	}
	@Test
	public void customerLogin()
	{
		driver=baseConfig.loadDriver("https://shop.moda/#/signin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			customerLogin.setMultipleUSer(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterSuite
	public void closeBrowser(){
		driver.quit();
	}
	
 
}
