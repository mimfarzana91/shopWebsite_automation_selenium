package shop.moda.automation.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import shop.moda.automation.lib.Constans;
import shop.moda.automation.lib.ExcelPathResource;
import shop.moda.automation.lib.ScreenShotPathResource;
import shop.moda.automation.models.Login;
import shop.moda.automation.repo.impl.CustomerLoginRepoImpl;
import shop.moda.automation.repo.interfaces.CustomerLoginRepo;
import shop.moda.automation.service.interfaces.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService {
	private CustomerLoginRepo customerLoginRepo = new CustomerLoginRepoImpl();
	private String currentUrl = null;
	final static Logger logger = Logger.getLogger(CustomerLoginServiceImpl.class);

	public void setMultipleUSer(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		WebElement webelement = driver.findElement(By.xpath(Constans.Home.FORM));
		if (webelement.isDisplayed()) {
			for (int i = 1; i < 5; i++) {
				setUserNamePassword(driver, i, ExcelPathResource.Customer_UserName.Sheetname);
				String Login_url = driver.getCurrentUrl();
				System.out.println(Login_url);

				if (Login_url.contains("dashboard")) {
					successfulLogin(driver);
				} else if (Login_url.contains("sign")) {
					unsuccessfulLogin(driver);
				}
			}

		}

	}

	public void setOneUser(WebDriver driver,String sheetName) {
		// TODO Auto-generated method stub
		
	}

	private void successfulLogin(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Constans.Customer_profile.PROFILE)).click();
		driver.findElement(By.xpath(Constans.Customer_profile.LOGOUT)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("signin"));
		if (!currentUrl.contains("signin")) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(ScreenShotPathResource.screenShot.Location));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setUserNamePassword(WebDriver driver, int i,String sheetName) {
		try {

			Login login = customerLoginRepo.get(i, sheetName);
			System.out.println(login);
			System.out.println("Inputing name: " + login.getUserName() + " and password: " + login.getPassword());
			driver.findElement(By.xpath(Constans.Login.USER_NAME)).sendKeys(login.getUserName());
			driver.findElement(By.xpath(Constans.Login.PASSWORD)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(Constans.Login.SUBMIT)).click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void unsuccessfulLogin(WebDriver driver) {
		String a = driver.findElement(By.xpath(Constans.Login.LoginMessage)).getText();
		logger.info("Error message " + a);
		driver.navigate().refresh();
	}

}
