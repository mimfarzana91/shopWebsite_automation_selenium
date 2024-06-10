package shop.moda.automation.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import shop.moda.automation.lib.ExcelPathResource;
import shop.moda.automation.service.impl.CustomerLoginServiceImpl;
import shop.moda.automation.service.impl.CustomerProfileServiceImpl;
import shop.moda.automation.service.impl.CustomerSignUpServiceImpl;
import shop.moda.automation.service.interfaces.CustomerLoginService;
import shop.moda.automation.service.interfaces.CustomerProfileService;
import shop.moda.automation.service.interfaces.CustomerSignUpService;

public class CustomerSignUp {
	private BaseConfiguration baseConfig=new BaseConfiguration();
	CustomerSignUpService customerSignup = new CustomerSignUpServiceImpl();
	CustomerLoginService customerLogin = new CustomerLoginServiceImpl();
	CustomerProfileService customerProfile = new CustomerProfileServiceImpl();
	private WebDriver driver=null;
	
	@BeforeSuite
	public void initEnvironment(){
		baseConfig.initEnvironment();
	}
	@Test
	public void customerSignUp(){
		driver=baseConfig.loadDriver("https://shop.moda/#/signin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    customerSignup.customerSignup(driver);
		customerLogin.setUserNamePassword(driver,1,ExcelPathResource.Customer_signup.Sheetname);
		//customerProfile.setCustomerProfileData(driver);
		
	}
	
	/*@AfterTest
	public void closeBrowser(){
		driver.quit();
	}*/
	
}
