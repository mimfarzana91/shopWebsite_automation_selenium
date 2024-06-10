package shop.moda.automation.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import shop.moda.automation.lib.Constans;
import shop.moda.automation.models.Login;
import shop.moda.automation.repo.impl.CustomerSignUpRepoImpl;
import shop.moda.automation.repo.interfaces.CustomerSignUpRepo;
import shop.moda.automation.service.interfaces.CustomerSignUpService;

public class CustomerSignUpServiceImpl implements CustomerSignUpService {

	private CustomerSignUpRepo customerSignUpRepo= new CustomerSignUpRepoImpl();
	final static Logger logger = Logger.getLogger(CustomerSignUpServiceImpl.class);
	public void customerSignup(WebDriver driver) {
		
		ArrayList<WebElement> a = new ArrayList<WebElement>();
		a.add(driver.findElement(By.xpath(Constans.Home.Signup)));
		a.add(driver.findElement(By.xpath(Constans.Home.Signin)));
		
		try {
			Login login = customerSignUpRepo.get(1);
			driver.findElement(By.xpath(Constans.Home.Signup)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Constans.CustomerSignUp.Email)).sendKeys(login.getUserName());
			driver.findElement(By.xpath(Constans.CustomerSignUp.Password)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(Constans.CustomerSignUp.Submit)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.navigate().refresh();
			driver.findElement(By.xpath(Constans.Home.Signin)).click();
			Assert.assertNotNull(a);
			// TODO Auto-generated method stub
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
