package shop.moda.automation.repo.impl;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;

import shop.moda.automation.lib.ExcelPathResource;
import shop.moda.automation.lib.ExcelUtils;
import shop.moda.automation.models.Login;
import shop.moda.automation.repo.interfaces.CustomerSignUpRepo;

public class CustomerSignUpRepoImpl implements CustomerSignUpRepo{

	public Login get(Integer rowId) throws IOException {
		// TODO Auto-generated method stub
		XSSFRow row=ExcelUtils.getExcellSheet(ExcelPathResource.Customer_signup.Location, ExcelPathResource.Customer_signup.Sheetname).getRow(rowId);
		Login login=new Login();
		login.setUserName(row.getCell(0).toString());
		login.setPassword(row.getCell(1).toString());
		return login;
	}

}
