package shop.moda.automation.repo.interfaces;

import java.io.IOException;

import shop.moda.automation.models.Login;

public interface CustomerSignUpRepo {
	public Login get(Integer rowId) throws IOException;
}
