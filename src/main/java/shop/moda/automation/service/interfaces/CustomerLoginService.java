package shop.moda.automation.service.interfaces;

import org.openqa.selenium.WebDriver;

public interface CustomerLoginService {
public void setOneUser(WebDriver driver,String sheetName);
public void setMultipleUSer(WebDriver driver) throws Exception;
public void setUserNamePassword(WebDriver driver, int i,String sheetName);
}
