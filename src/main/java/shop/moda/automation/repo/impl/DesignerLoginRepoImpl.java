package shop.moda.automation.repo.impl;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;

import shop.moda.automation.lib.ExcelPathResource;
import shop.moda.automation.lib.ExcelUtils;
import shop.moda.automation.models.Login;
import shop.moda.automation.repo.interfaces.DesignerLoginRepo;

public class DesignerLoginRepoImpl implements DesignerLoginRepo {
	
	public Login get(Integer rowId) throws IOException {
		XSSFRow row=ExcelUtils.getExcellSheet(ExcelPathResource.Designer_UserName.Location, ExcelPathResource.Designer_UserName.SheetName).getRow(rowId);
		Login login=new Login();
		login.setUserName(row.getCell(0).toString());
		login.setPassword(row.getCell(1).toString());
		return login;
	}
}
