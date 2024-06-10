package shop.moda.automation.service.interfaces;

import org.openqa.selenium.WebDriver;

public interface DesignerLoginService {
	public void setValuesFromExcel(WebDriver driver);
	public void validDesignerLogin(WebDriver driver);
	public void designerLogout(WebDriver driver);
}