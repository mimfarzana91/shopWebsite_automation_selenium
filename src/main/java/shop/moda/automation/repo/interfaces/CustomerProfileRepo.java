package shop.moda.automation.repo.interfaces;

import shop.moda.automation.models.CustomerProfile;

public interface CustomerProfileRepo {
	public CustomerProfile get(int rowId) throws Exception;
}
