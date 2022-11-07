package execution;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import actionkeywords.ActionKeywords;
import utilities.ExcelUtilities;

public class Engine {

	ActionKeywords actionKeyword;
	Method[] methods;
	static String  keyword;
	
	public void getActionKeywords() {
		/*ActionKeywords actionKeyword = new ActionKeywords();
		Method[] methods = actionKeyword.getClass().getMethods();*/
		
		actionKeyword = new ActionKeywords();
		methods = actionKeyword.getClass().getMethods();
		
	}
	
	public void executeKeywords() throws Exception {
		for(int i = 0; i< methods.length; i++) {
			if(methods[i].getName().equalsIgnoreCase(keyword)) {
				methods[i].invoke(actionKeyword);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		ExcelUtilities utility = new ExcelUtilities();
		utility.readExcelFile("src\\test\\resources\\keywordDriven.xlsx");
		
		Engine engine = new Engine();
		
		engine.getActionKeywords();
		
		for(int row = 1; row<=5; row++) {
			keyword = utility.getCellContentFromExcel(row, 3);
			engine.executeKeywords();
		
		/*
		 * if(keyword.equalsIgnoreCase("openBrowser")) { ActionKeywords.openBrowser();
		 * }else if (keyword.equalsIgnoreCase("goToURL")) { ActionKeywords.goToURL();
		 * }else if (keyword.equalsIgnoreCase("enterUsername")) {
		 * ActionKeywords.enterUsername(); }else if
		 * (keyword.equalsIgnoreCase("enterPassword")) { ActionKeywords.enterPassword();
		 * }else if (keyword.equalsIgnoreCase("clickLogin")) {
		 * ActionKeywords.clickLogin(); }
		 */
}
	}
}
