package shop.moda.automation.repo.impl;

import org.apache.poi.xssf.usermodel.XSSFRow;

import shop.moda.automation.lib.ExcelPathResource;
import shop.moda.automation.lib.ExcelUtils;
import shop.moda.automation.models.CustomerProfile;
import shop.moda.automation.repo.interfaces.CustomerProfileRepo;

public class CustomerProfileRepoImpl implements CustomerProfileRepo {

	public CustomerProfile get(int rowId) throws Exception {
		// TODO Auto-generated method stub
		XSSFRow row=ExcelUtils.getExcellSheet(ExcelPathResource.Customer_profile.Location, ExcelPathResource.Customer_profile.Sheetname).getRow(rowId);
		CustomerProfile customerProfile =new CustomerProfile();
		customerProfile.setFirstName(row.getCell(0).toString());
		customerProfile.setMiddleName(row.getCell(1).toString());
		customerProfile.setLastName(row.getCell(2).toString());
		customerProfile.setMobileNumber(row.getCell(1).toString());
		return customerProfile;
	}

}
