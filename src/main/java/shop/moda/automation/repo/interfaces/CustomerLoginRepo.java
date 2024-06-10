package shop.moda.automation.repo.interfaces;

import shop.moda.automation.models.Login;

public interface CustomerLoginRepo {
	public Login get(int rowId, String sheetName) throws Exception;

}
