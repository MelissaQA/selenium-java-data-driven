package org.automation.testingworld.datagenerators;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {

	// @DataProvider(name="Static")
	@DataProvider(name = "Excel")
	public static Object[][] testDataGenerator(Method met) throws Exception {
		// Session 196 -> static data provider
		// Object [][] data = {{"Unam1","Pass"},{"Unam2","Pass2"}};
		// return data;
		if(met.getName().equalsIgnoreCase("tc_001_login_functionality")) {
			FileInputStream file = new FileInputStream("./TestData/data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet loginSheet = workbook.getSheet("login");
			int numberOfData = loginSheet.getPhysicalNumberOfRows();
			Object[][] testData = new Object[numberOfData][2];

			for (int i = 0; i < numberOfData; i++) {
				XSSFRow row = loginSheet.getRow(i);
				XSSFCell username = row.getCell(0);
				XSSFCell password = row.getCell(1);
				testData[i][0] = username.getStringCellValue();
				testData[i][1] = password.getStringCellValue();
			}

			return testData;		
		}
		/*else if (método de otro test case){
		 * 		otra secuencia de dataprovider
		 * }
		 * */
		else {
			Object[][] testData = new Object[2][2];
			return testData;
		}
		

	}
	
	/*Creating another data provider:
	 * 
	 * @DataProvider(name = "Register")
		public static Object[][] testDataGeneratorRegister()
	 * 
	 * 
	 * */

}
