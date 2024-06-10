package shop.moda.automation.repo.impl;

import org.apache.poi.xssf.usermodel.XSSFRow;

import shop.moda.automation.lib.ExcelPathResource;
import shop.moda.automation.lib.ExcelUtils;
import shop.moda.automation.models.Login;
import shop.moda.automation.repo.interfaces.CustomerLoginRepo;

public class CustomerLoginRepoImpl implements CustomerLoginRepo {

	public Login get(int rowId,String sheetName) throws Exception {
		// TODO Auto-generated method stub
		
		XSSFRow row=ExcelUtils.getExcellSheet(ExcelPathResource.Customer_UserName.Location, sheetName).getRow(rowId);
		Login login=new Login();
		login.setUserName(row.getCell(0).toString());
		login.setPassword(row.getCell(1).toString());
		return login;
	}

}
