package shop.moda.automation.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet sheet=null;
	public static XSSFSheet getExcellSheet(String location, String sheetName) throws IOException
	{
		FileInputStream fis;
		fis = new FileInputStream(location);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		return sheet = wb.getSheet(sheetName);
	}
	
}
