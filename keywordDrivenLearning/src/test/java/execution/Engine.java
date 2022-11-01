package execution;

import java.io.IOException;

import actionkeywords.ActionKeywords;
import utilities.ExcelUtilities;

public class Engine {

	public static void main(String[] args) throws IOException {
		
		ExcelUtilities utility = new ExcelUtilities();
		utility.readExcelFile("src\\test\\resources\\keywordDriven.xlsx");
		
		
		for(int row = 1; row<=5; row++) {
		String keyword = 
				utility.getCellContentFromExcel(row, 3);
		
		if(keyword.equalsIgnoreCase("openBrowser")) {
			ActionKeywords.openBrowser();
		}else if (keyword.equalsIgnoreCase("goToURL")) {
			ActionKeywords.goToURL();
		}else if (keyword.equalsIgnoreCase("enterUsername")) {
			ActionKeywords.enterUsername();
		}else if (keyword.equalsIgnoreCase("enterPassword")) {
			ActionKeywords.enterPassword();
	}else if (keyword.equalsIgnoreCase("clickLogin")) {
		ActionKeywords.clickLogin();
}
}
	}
}
