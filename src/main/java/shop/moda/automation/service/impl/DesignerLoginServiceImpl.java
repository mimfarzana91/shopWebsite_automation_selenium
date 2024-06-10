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

import shop.moda.automation.lib.Constans;
import shop.moda.automation.lib.ScreenShotPathResource;
import shop.moda.automation.models.Login;
import shop.moda.automation.repo.impl.DesignerLoginRepoImpl;
import shop.moda.automation.repo.interfaces.DesignerLoginRepo;
import shop.moda.automation.service.interfaces.DesignerLoginService;

public class DesignerLoginServiceImpl implements DesignerLoginService {
	private DesignerLoginRepo designerLoginRepo = new DesignerLoginRepoImpl();
	private String currentUrl = null;
	final static Logger logger = Logger.getLogger(DesignerLoginServiceImpl.class);

	public void setValuesFromExcel(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement webelement = driver.findElement(By.xpath(Constans.Home.FORM));
		if (webelement.isDisplayed()) {
			for (int i = 1; i < 5; i++) {
				setUserNameAndPassword(driver, i);

				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String Login_url = driver.getCurrentUrl();
				System.out.println(Login_url);

				if (Login_url.contains("video-management")) {
					successfulLogin(driver);
				} else if (Login_url.contains("sign")) {
					unsuccessfulLogin(driver);
				}
				/*else
				{
					
					try {
						File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(scrFile, new File(ScreenShotPathResource.screenShot.Location));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
			}
		}
	}

	private void successfulLogin(WebDriver driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Constans.Designer_Profile.PROFILE)).click();
			
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
	}

	private void unsuccessfulLogin(WebDriver driver) {
		String a = driver.findElement(By.xpath(Constans.Login.LoginMessage)).getText();
		/* System.out.println(a); */
		logger.info("Test Message");
		logger.info("Test= " + a);
		driver.navigate().refresh();
	}

	private void setUserNameAndPassword(WebDriver driver, int i) {
		try {
			Login login = designerLoginRepo.get(i);
			System.out.println(login);
			System.out.println("Inputing name: " + login.getUserName() + " and password: " + login.getPassword());

			driver.findElement(By.xpath(Constans.Login.USER_NAME)).sendKeys(login.getUserName());
			driver.findElement(By.xpath(Constans.Login.PASSWORD)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(Constans.Login.SUBMIT)).click();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void validDesignerLogin(WebDriver driver) {
		// TODO Auto-generated method stub
		setUserNameAndPassword(driver, 1);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		successfulLogin(driver);
	}

	public void designerLogout(WebDriver driver) {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath(Constans.Designer_Profile.LOGOUT)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		/*Assert.assertTrue(currentUrl.contains("signin"));*/
		if (!currentUrl.contains("signin")) {
			
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(ScreenShotPathResource.screenShot.Location));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
