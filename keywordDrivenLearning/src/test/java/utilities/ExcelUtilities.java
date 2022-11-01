package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	public void readExcelFile(String location) throws IOException {
		//file location
		file = new FileInputStream(location);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");
	}
	
	public String getCellContentFromExcel(int rowNum, int cellNum) {
		cell =  sheet.getRow(rowNum).getCell(cellNum);
		String cellValue = cell.getStringCellValue();
		System.out.println(cellValue);
		return cellValue;
		}
	
}
