package shop.moda.automation.service.impl;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import shop.moda.automation.lib.Constans;
import shop.moda.automation.models.CustomerProfile;
import shop.moda.automation.repo.impl.CustomerProfileRepoImpl;
import shop.moda.automation.repo.interfaces.CustomerProfileRepo;
import shop.moda.automation.service.interfaces.CustomerProfileService;

public class CustomerProfileServiceImpl implements CustomerProfileService {
	private CustomerProfileRepo customerProfileRepo = new CustomerProfileRepoImpl();
	final static Logger logger = Logger.getLogger(CustomerProfileServiceImpl.class);
	public void setCustomerProfileData(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			CustomerProfile customerProfile = customerProfileRepo.get(1);
			driver.findElement(By.xpath(Constans.Customer_profile.PROFILE_SETTING)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Constans.Customer_profile.Screen_name)).sendKeys(customerProfile.getScreenName());
			driver.findElement(By.xpath(Constans.Customer_profile.First_name)).sendKeys(customerProfile.getFirstName());
			driver.findElement(By.xpath(Constans.Customer_profile.Middle_name)).sendKeys(customerProfile.getMiddleName());
			driver.findElement(By.xpath(Constans.Customer_profile.Last_name)).sendKeys(customerProfile.getLastName());
			driver.findElement(By.xpath(Constans.Customer_profile.Gender)).click();
			
			Select dropdown = new Select(driver.findElement(By.xpath(Constans.Customer_profile.Nationality)));
			dropdown.selectByValue("Bangladesh");
			driver.findElement(By.xpath(Constans.Customer_profile.Mobile_number)).sendKeys(customerProfile.getMobileNumber());
			driver.findElement(By.xpath(Constans.Customer_profile.Save)).click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
