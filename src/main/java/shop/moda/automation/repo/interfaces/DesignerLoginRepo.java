package shop.moda.automation.repo.interfaces;

import java.io.IOException;

import shop.moda.automation.models.Login;

public interface DesignerLoginRepo {
//public void excelInput(XSSFSheet sheet,XSSFRow row) throws IOException;
public Login get(Integer rowId) throws IOException;
}
